package persons;

import java.time.LocalDate;

public class Person {

    LocalDate birthDate;
    private String name;

    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthDate = birthday;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setId(int id) {
    }

    public void setName(String name) {
        this.name = name;
    }

}