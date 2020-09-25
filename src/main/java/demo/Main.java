package demo;

import demo.lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] arguments) {
        // private final fields
        LombokPersonWithFinalFields lombokPersonWithFinalFields = new LombokPersonWithFinalFields("Doe", "John", 30);
        // LombokPersonWithFinalFields lombokPersonWithFinalFields2 = new LombokPersonWithFinalFields(); // expected 3 arguments but found 0
        // lombokPersonWithFinalFields.setAge(31);  // not allowed here (final field), mutator not generated at all


        // private non-final fields
        LombokPersonWithNonFinalFields lombokPersonWithNonFinalFields = new LombokPersonWithNonFinalFields();
        // LombokPersonWithNonFinalFields lombokPersonWithNonFinalFields2 = new LombokPersonWithNonFinalFields("Doe", "John", 30);    // expected 0 arguments but found 3
        log.info("Non-final before value init: {}", lombokPersonWithNonFinalFields.toString());
        lombokPersonWithNonFinalFields.setSurname("Doe");
        lombokPersonWithNonFinalFields.setGivenName("John");
        lombokPersonWithNonFinalFields.setAge(30);
        log.info("Non-final after value init: {}", lombokPersonWithNonFinalFields.toString());


        // mixed fields
        // LombokPersonWithMixedFields lombokPersonWithMixedFieldsNullCheckPasses = new LombokPersonWithMixedFields("Doe", null);
        // LombokPersonWithMixedFields lombokPersonWithMixedFieldsNullCheckFails = new LombokPersonWithMixedFields(null, "John");
        LombokPersonWithMixedFields lombokPersonWithMixedFields = new LombokPersonWithMixedFields("Doe", "John");
        log.info("Mixed before value init: {}", lombokPersonWithMixedFields.toString());
        lombokPersonWithMixedFields.setAge(30);
        log.info("Mixed after assigning an even number to age: {}", lombokPersonWithMixedFields.toString());
        lombokPersonWithMixedFields.setAge(31);
        log.info("Mixed after assigning an odd number to age: {}", lombokPersonWithMixedFields.toString());

        LombokPersonWithMixedFields lombokPersonWithMixedFieldsDefault = new LombokPersonWithMixedFields();
        log.info("Mixed (default) before value init: {}", lombokPersonWithMixedFieldsDefault.toString());
        // lombokPersonWithMixedFieldsDefault.setSurname("Doe");   // not allowed here (final field), mutator not generated at all
        lombokPersonWithMixedFieldsDefault.setAge(20);
        log.info("Mixed (default) after value init: {}", lombokPersonWithMixedFieldsDefault.toString());

        // a few options here (custom NoArgsConstructor + Lombok-generated RequiredArgsConstructor + Lombok-generated AllArgsConstructor)
        LombokPersonWithAllArgsConstructor lombokPersonWithAllArgsConstructor1 = new LombokPersonWithAllArgsConstructor();
        log.info("Mixed (constructors) with NoArgsConstructor: {}", lombokPersonWithAllArgsConstructor1.toString());
        LombokPersonWithAllArgsConstructor lombokPersonWithAllArgsConstructor2 = new LombokPersonWithAllArgsConstructor("Doe", "John");
        log.info("Mixed (constructors) with RequiredArgsConstructor: {}", lombokPersonWithAllArgsConstructor2.toString());
        LombokPersonWithAllArgsConstructor lombokPersonWithAllArgsConstructor3 = new LombokPersonWithAllArgsConstructor("Doe", "John", 30);
        log.info("Mixed (constructors) with AllArgsConstructor: {}", lombokPersonWithAllArgsConstructor3.toString());

        LombokPersonWithAccessorsMutators lombokPersonWithAccessorsMutators1 = new LombokPersonWithAccessorsMutators();
        log.info("Mixed (accessors-mutators) with NoArgsConstructor (printed with toString): {}", lombokPersonWithAccessorsMutators1.toString());
        log.info("Mixed (accessors-mutators) with NoArgsConstructor: {} {} ({})",
                new Object[]{
                        lombokPersonWithAccessorsMutators1.getGivenName(),
                        lombokPersonWithAccessorsMutators1.getSurname(),
                        lombokPersonWithAccessorsMutators1.getAge()});
        //lombokPersonWithAccessorsMutators1.setSurname("Doe");   // not allowed here (final field), mutator not generated at all
        LombokPersonWithAccessorsMutators lombokPersonWithAccessorsMutators2 = new LombokPersonWithAccessorsMutators("Doe", "John");
        log.info("Mixed (accessors-mutators) with 2-ArgsConstructor: {} {} ({})",
                new Object[]{
                        lombokPersonWithAccessorsMutators2.getGivenName(),
                        lombokPersonWithAccessorsMutators2.getSurname(),
                        lombokPersonWithAccessorsMutators2.getAge()});
        lombokPersonWithAccessorsMutators2.setGivenName("Johnny");
        lombokPersonWithAccessorsMutators2.setAge(20);
        log.info("Mixed (accessors-mutators) with 2-ArgsConstructor (after assignments): {} {} ({})",
                new Object[]{
                        lombokPersonWithAccessorsMutators2.getGivenName(),
                        lombokPersonWithAccessorsMutators2.getSurname(),
                        lombokPersonWithAccessorsMutators2.getAge()});

        LombokPersonBuilder lombokPersonBuilder1 = LombokPersonBuilder.builder().build();
        log.info("Builder pattern (empty): {}", lombokPersonBuilder1.toString());
        LombokPersonBuilder lombokPersonBuilder2 = LombokPersonBuilder.builder()
                .surname("Doe")
                .givenName("John")
                .age(30)
                .build();
        log.info("Builder pattern (constructor-annotated, fluent style): {}", lombokPersonBuilder2.toString());
        LombokImmutablePerson lombokImmutablePerson = ImmutablePersonBuilder.myBuilder()
                .surname("Doe")
                .givenName("John")
                .age(30)
                .build();
        log.info("Builder pattern (method-annotated (final class), fluent style): {}", lombokImmutablePerson.toString());
    }

}
