package demo.plain;

import demo.lombok.LombokPersonWithNonFinalFields;
import org.apache.commons.lang3.StringUtils;

public class Person {

    private String surname;
    private String givenName;
    private int age;

    // Constructor(s)
    public Person() {
        surname = "";
        givenName = "";
        age = 0;
    }

    public Person(String surname, String givenName, int age) {
        this.surname = surname;
        this.givenName = givenName;
        this.age = age;
    }

    // Accessors and mutators
    public String getSurname() {
        return this.surname;
    }

    public String getGivenName() {
        return this.givenName;
    }

    public int getAge() {
        return this.age;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // For object comparison
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof LombokPersonWithNonFinalFields)) {
            return false;
        } else {
            LombokPersonWithNonFinalFields other = (LombokPersonWithNonFinalFields)o;
            try {
                compareNames(this.getSurname(), other.getSurname());
                compareNames(this.getGivenName(), other.getGivenName());
                compareAges(this.getAge(), other.getAge());
                return true;
            } catch (Person.ObjectsDifferException objectsDifferException) {
                return false;
            }
        }
    }

    public int hashCode() {
        Object surnameTemp = this.getSurname();
        int result = 59 + (surnameTemp == null ? 43 : surnameTemp.hashCode());
        Object givenNameTemp = this.getGivenName();
        result = result * 59 + (givenNameTemp == null ? 43 : givenNameTemp.hashCode());
        result = result * 59 + this.getAge();
        return result;
    }

    // For logging
    public String toString() {
        return "LombokPersonWithNonFinalFields(" +
                "surname=" + this.getSurname() +
                ", givenName=" + this.getGivenName() +
                ", age=" + this.getAge() +
                ")";
    }

    private static class ObjectsDifferException extends Exception {}

    private static void compareNames(String name, String otherName) throws ObjectsDifferException {
        if (StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(otherName)) {
            if (!name.equals(otherName)) {
                throw new ObjectsDifferException();
            }
        } else {
            if ((name == null && otherName != null) || (name != null && otherName == null)) {
                throw new ObjectsDifferException();
            }
            if (name != null && name.length() != otherName.length()) {
                throw new ObjectsDifferException();
            }
        }
    }

    private static void compareAges(int age, int otherAge) throws ObjectsDifferException {
        if (age != otherAge) {
            throw new ObjectsDifferException();
        }
    }
}
