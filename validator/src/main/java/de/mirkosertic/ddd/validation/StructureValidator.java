package de.mirkosertic.ddd.validation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import java.util.Set;

public class StructureValidator extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> aAnnotations, RoundEnvironment aEnvironment) {
        return false;
    }
}
