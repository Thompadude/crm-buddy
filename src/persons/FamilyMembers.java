package persons;

import java.time.LocalDate;
import  java.util.*;

public class FamilyMembers {

	private Person companion;
	private ArrayList<Person> children;

	public Person getCompanion() {
		return this.companion;
	}

	public ArrayList<Person> getChildren() {
		return this.children;
	}

	public void setChildren(ArrayList<Person> children){

		this.children = children;
	}

	public void setCompanion (Person companion) {

		this.companion = companion;
	}

	public void addChild(Person child){

		children.add(child);
	}


}