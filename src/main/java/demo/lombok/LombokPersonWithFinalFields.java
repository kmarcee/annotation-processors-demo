package demo.lombok;

import lombok.Data;

@Data
public class LombokPersonWithFinalFields {

    private final String surname;
    private final String givenName;
    private final int age;

}
