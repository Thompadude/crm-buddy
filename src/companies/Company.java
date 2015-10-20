package companies;

import persons.Associate;
import persons.ContactInfo;

import java.util.ArrayList;

public class Company {

    private String name;
    private ContactInfo contactInfo;
    private ArrayList<Meeting> meetings;
    private ArrayList<Associate> employees;
    private ArrayList<Associate> businessAssociates;

    public Company(String name, ContactInfo contactInfo) {
        // TODO i UI:t måste temporär ContactInfo skapas och skickas in i denna konstruktor.
        this.name = name;
        this.contactInfo = contactInfo;
        // TODO Eager loading! (Vi kanske byter till lazy loading)
        this.meetings = new ArrayList<Meeting>();
        this.employees = new ArrayList<Associate>();
        this.businessAssociates = new ArrayList<Associate>();
    }

    public String getName() {
        return name;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }

    public ArrayList<Associate> getEmployees() {
        return employees;
    }

    public ArrayList<Associate> getBusinessAssociates() {
        return businessAssociates;
    }

}