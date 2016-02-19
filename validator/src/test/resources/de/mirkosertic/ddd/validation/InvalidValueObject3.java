import de.mirkosertic.ddd.annotation.ValueObject;

@ValueObject
public class InvalidValueObject3 {

    private final Test test;

    InvalidValueObject3() {
        test = null;
    }
}

class Test {
}
