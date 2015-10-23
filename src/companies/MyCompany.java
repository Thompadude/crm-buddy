package companies;

import persons.Associate;

import java.util.ArrayList;

import contactInfo.ContactInfo;

public class MyCompany extends Company {

	private ArrayList<Meeting> meetings;
	private ArrayList<Associate> employees;
	private ArrayList<Associate> businessAssociates;
	private ArrayList<Associate> pastContacts;

	public MyCompany(String name, ContactInfo contactInfo) {
		// TODO i UI:t måste temporär ContactInfo skapas och skickas in i
		// denna konstruktor.
		super(name, contactInfo);
		// TODO Eager loading! (Vi kanske byter till lazy loading)
		// detta ska tas bort
		// this.meetings = new ArrayList<Meeting>();
	}

	public ArrayList<Meeting> getMeetings() {
		return meetings;
	}

	public void createMeetings() {
		this.meetings = new ArrayList<Meeting>();
	}

	public ArrayList<Associate> getEmployees() {
		return employees;
	}

	public ArrayList<Associate> getBusinessAssociates() {
		return businessAssociates;
	}

	public ArrayList<Associate> getPastContacts(){

		return this.pastContacts;
	}

	public void addPastContact(Associate contact){

		this.pastContacts.add(contact);
	}

	public void addEmployee(Associate associate) {
		// Lazy loading
		if (employees == null) {
			employees = new ArrayList<Associate>();
		}
		employees.add(associate);
	}

	public void addBusinessAssociate(Associate associate) {
		// Lazy loading
		if (businessAssociates == null) {
			businessAssociates = new ArrayList<Associate>();
		}
		businessAssociates.add(associate);
	}

}