package demo.lombok;

import lombok.Builder;

public class ImmutablePersonBuilder {

    private ImmutablePersonBuilder() {}

    @Builder(builderMethodName = "myBuilder")
    public static LombokImmutablePerson newLombokImmutablePerson(String surname, String givenName, int age) {
        return new LombokImmutablePerson(surname, givenName, age);
    }

}
