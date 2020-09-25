package demo.lombok;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

// following the Java Bean specification
@NoArgsConstructor
@Setter
@Getter
public class LombokPersonJavaBean implements Serializable {

    private String surname;
    private String givenName;
    private int age;

}
