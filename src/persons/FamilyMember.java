package persons;

import java.time.LocalDate;

public class FamilyMember extends Person {

    private Family family;

    public FamilyMember(String name, LocalDate birthday, Family family) {
        super(name, birthday);
        this.family = family;
    }

    public Family getFamily() {
        return family;
    }

}