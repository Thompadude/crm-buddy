package companies;

import contactInfo.ContactInfo;
import persons.Associate;

import java.util.ArrayList;

public class MyCompany extends Company {

    private ArrayList<Meeting> meetings;
    private ArrayList<Associate> employees;
    private ArrayList<Associate> businessAssociates;
    private ArrayList<Associate> pastContacts;
    private ArrayList<Company> associatedCompanies;

    public MyCompany(String name, ContactInfo contactInfo) {
        super(name, contactInfo);
    }

    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }

    public void createMeetings() {
        this.meetings = new ArrayList<>();
    }

    public ArrayList<Associate> getEmployees() {
        return employees;
    }

    public ArrayList<Associate> getBusinessAssociates() {
        return businessAssociates;
    }

    public ArrayList<Associate> getPastContacts() {
        return this.pastContacts;
    }

    public void createPastContacts() {
        this.pastContacts = new ArrayList<>();
    }

    public void addPastContact(Associate contact) {
        this.pastContacts.add(contact);
    }

    public void addEmployee(Associate associate) {
        if (employees == null) {
            employees = new ArrayList<>();
        }
        employees.add(associate);
    }

    public void addBusinessAssociate(Associate associate) {
        if (businessAssociates == null) {
            businessAssociates = new ArrayList<>();
        }
        businessAssociates.add(associate);
    }

    public ArrayList<Company> getAssociatedCompanies() {
        return associatedCompanies;
    }

    public void addAssociatedCompany(Company associatedCompanies) {
        if ((this.associatedCompanies == null)) {
            this.associatedCompanies = new ArrayList<>();
        }

        boolean companyAlreadyAdded = false;
        for (int i = 0; i < this.associatedCompanies.size(); i++) // Why no clams here?

            if (this.associatedCompanies.get(i).getName().equals(associatedCompanies.getName())) {
                companyAlreadyAdded = true;
                break;
            }

        if (!companyAlreadyAdded) {
            this.associatedCompanies.add(associatedCompanies);
        }
    }

}