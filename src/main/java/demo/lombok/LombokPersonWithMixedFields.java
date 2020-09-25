package demo.lombok;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LombokPersonWithMixedFields {

    @NonNull
    private final String surname;
    private final String givenName;
    private int age;

    public LombokPersonWithMixedFields() {
        this.surname = "DefaultSurname";
        this.givenName = "DefaultGivenName";
        this.age = 10;
    }

    // override default setter with custom logic (e.g. for validation purpose)
    public void setAge(int age) {
        if (age % 2 == 0) {
            this.age = age * 2;
        } else {
            this.age = age;
        }
    }
}
