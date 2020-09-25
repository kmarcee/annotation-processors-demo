package demo.lombok;

import lombok.Value;

// final class
@Value
public class LombokImmutablePerson {

    String surname;
    String givenName;
    int age;

}
