package de.mirkosertic.ddd.validation;

import de.mirkosertic.ddd.annotation.ValueObject;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;

import java.util.HashSet;
import java.util.Set;

import static de.mirkosertic.ddd.validation.ModelHelper.*;

public class ValueObjectValidator extends AbstractProcessor {

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> theResult = new HashSet<>();
        theResult.add(ValueObject.class.getName());
        return theResult;
    }

    @Override
    public boolean process(Set<? extends TypeElement> aAnnotations, RoundEnvironment aEnvironment) {
        for (TypeElement theAnnotation : aAnnotations) {
            for (Element theElement : aEnvironment.getElementsAnnotatedWith(theAnnotation)) {
                validate(theElement, aEnvironment);
            }
        }
        return false;
    }

    private void validate(Element aElement, RoundEnvironment aEnvironment) {
        if (!isClass(aElement)) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Only classes can be annotated that way");
        }

        for (Element theEnclosedElement : getFields(aElement)) {
            if (!hasModifier(theEnclosedElement, Modifier.FINAL)) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Field " + theEnclosedElement.getSimpleName()+" is not final!");
            }
            TypeMirror theTypeMirror = theEnclosedElement.asType();
            if (theTypeMirror.toString().startsWith("java.")) {
                continue;
            } else {
                if (TypeKind.DECLARED == theTypeMirror.getKind()) {
                    DeclaredType theDeclaredType = (DeclaredType) theTypeMirror;
                    Element theDeclaredElement = theDeclaredType.asElement();
                    if (!isEnum(theDeclaredElement)) {
                        if (theDeclaredElement.getAnnotation(ValueObject.class) == null) {
                            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                                    "Field " + theEnclosedElement.getSimpleName() + " is not a ValueObject!");
                        }
                    }
                }
            }
        }
    }
}
