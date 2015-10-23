package persons;

import java.time.LocalDate;

public class FamilyMember extends Person {

    private Family family;

    public FamilyMember(int id, String name, LocalDate birthday, Family family) {
        super(id, name, birthday);
        this.family = family;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

}