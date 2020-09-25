package demo.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class LombokPersonWithAllArgsConstructor {
    private final String surname;
    private final String givenName;
    private int age;

    public LombokPersonWithAllArgsConstructor() {
        this.surname = "DefaultSurname";
        this.givenName = "DefaultGivenName";
        this.age = 10;
    }
}
