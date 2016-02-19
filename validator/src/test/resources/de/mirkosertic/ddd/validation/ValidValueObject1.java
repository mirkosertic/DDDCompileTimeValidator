import de.mirkosertic.ddd.annotation.ValueObject;

import java.util.Date;

@ValueObject
public class ValidValueObject1 {

    public static enum TestType {

    };

    private final String member1;
    private final Date member2;
    private final ValidValueObject1 member3;
    private final TestType testType;

    ValidValueObject1() {
        member1 = null;
        member2 = null;
        member3 = null;
        testType = null;
    }
}