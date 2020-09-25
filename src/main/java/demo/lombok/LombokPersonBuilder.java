package demo.lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class LombokPersonBuilder {

    private final String surname;
    private final String givenName;
    private final int age;

}
