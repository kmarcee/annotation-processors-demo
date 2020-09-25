package demo.lombok;

import lombok.Data;

@Data
public class LombokPersonWithNonFinalFields {

    private String surname;
    private String givenName;
    private int age;

}
