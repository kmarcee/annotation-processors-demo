package demo.lombok;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
public class LombokPersonWithAccessorsMutators {

    // we cannot set the surname except for the 2-args constructor!!!
    private String surname;
    @Setter private String givenName;
    private int age;

    public LombokPersonWithAccessorsMutators(String surname, String givenName) {
        this.surname = surname;
        this.givenName = givenName;
        this.age = 100;
    }

    // implement custom setter (e.g. for validation purpose)
    public void setAge(int age) {
        if (age % 2 == 0) {
            this.age = age * 2;
        } else {
            this.age = age;
        }
    }
}
