package de.mirkosertic.ddd.validation;

import org.junit.Test;

import com.google.testing.compile.JavaFileObjects;

import static com.google.testing.compile.JavaSourceSubjectFactory.*;
import static com.google.common.truth.Truth.*;

public class ValueObjectValidatorTest {

    @Test
    public void testInvalidValueObject1() {
        ASSERT.about(javaSource())
                .that(JavaFileObjects.forResource("de/mirkosertic/ddd/validation/InvalidValueObject1.java"))
                .processedWith(new ValueObjectValidator())
                .failsToCompile()
                .withErrorContaining("Field member is not final");
    }

    @Test
    public void testInvalidValueObject2() {
        ASSERT.about(javaSource())
                .that(JavaFileObjects.forResource("de/mirkosertic/ddd/validation/InvalidValueObject2.java"))
                .processedWith(new ValueObjectValidator())
                .failsToCompile()
                .withErrorContaining("Only classes can be annotated that way");
    }

    @Test
    public void testInvalidValueObject3() {
        ASSERT.about(javaSource())
                .that(JavaFileObjects.forResource("de/mirkosertic/ddd/validation/InvalidValueObject3.java"))
                .processedWith(new ValueObjectValidator())
                .failsToCompile()
                .withErrorContaining("Field test is not a ValueObject!");
    }

    @Test
    public void testValidValueObject1() {
        ASSERT.about(javaSource())
                .that(JavaFileObjects.forResource("de/mirkosertic/ddd/validation/ValidValueObject1.java"))
                .processedWith(new ValueObjectValidator())
                .compilesWithoutError();
    }
}