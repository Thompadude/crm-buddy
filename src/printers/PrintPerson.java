package printers;

import persons.*;

public class PrintPerson implements PrintManage {

	public <T extends Person> void printName(T person) {
		System.out.println("Name: " + person.getName());
	}

	public <T extends Person> void printBirthday(T person) {
		System.out.println("Birthday: " + person.getBirthday());
	}

	//for future sub-classes, input else if instanceof
	@Override
	public <T> void printContactInfo(T t) {
		if(t instanceof Associate) {
			System.out.println(((Associate) t).getName() + " Contact Info: ");
			System.out.println("Email: " + ((Associate) t).getContactInfo().getEmail());
			System.out.println("Phone Number: " + ((Associate) t).getContactInfo().getPhoneNumber());
			System.out.println("Address: " + ((Associate) t).getContactInfo().getAddress());
		}
	}

	// TODO fixa print för family.

}