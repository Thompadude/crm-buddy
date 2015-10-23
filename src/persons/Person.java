package persons;

import java.time.LocalDate;

public class Person {

    LocalDate birthDate;
    // TODO Vi måste fixa ID-påplusning! Eventuellt i en factory!
    private int id;
    private String name;
    private FamilyMembers family;

    public Person(int id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        // this.birthday = birthday;
        // TODO fixa Birthday(inte hard-coded)
        this.birthDate = LocalDate.of(1983, 12, 11);
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        // Eventuellt override toString efter önskad formatering.
        return birthDate;
    }

}