package persons;

import java.time.LocalDate;

public class Person implements java.io.Serializable {

    LocalDate birthDate;
    private String name;
    private String familyNote = "";

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


    public void setName(String name) {
        this.name = name;
    }

    public void addFamilyNote(String familyNote) {
        this.familyNote += "\n" + familyNote;
    }

    public String getFamilyNote() {
        return this.familyNote;
    }

}