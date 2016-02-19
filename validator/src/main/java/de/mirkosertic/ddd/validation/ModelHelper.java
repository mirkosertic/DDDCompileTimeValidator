package de.mirkosertic.ddd.validation;

import java.util.ArrayList;
import java.util.Collection;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;

public class ModelHelper {

    private ModelHelper() {
    }

    public static boolean hasModifier(Element aElement, Modifier aModifier) {
        for (Modifier theModifier : aElement.getModifiers()) {
            if (theModifier == aModifier) {
                return true;
            }
        }
        return false;
    }

    public static boolean isClass(Element aElement) {
        return aElement.getKind() == ElementKind.CLASS;
    }

    public static boolean isEnum(Element aElement) {
        return aElement.getKind() == ElementKind.ENUM;
    }

    public static Collection<Element> getFields(Element aElement) {
        Collection<Element> theResult = new ArrayList<>();
        for (Element theEnclosed : aElement.getEnclosedElements()) {
            if (theEnclosed.getKind().isField()) {
                theResult.add(theEnclosed);
            }
        }
        return theResult;
    }
}
