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

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFamily(FamilyMembers family) {
		this.family = family;
	}

	public FamilyMembers getFamily() {
		return family;
	}
	
	
   

}