package printers;

import companies.Company;
import companies.MyCompany;
import persons.Associate;

public class PrintCompany implements Printable {

    protected void printName(MyCompany company) {
        System.out.println("Company Name: " + company.getName());
    }

    protected void printEmployees(MyCompany company) {
        for (Associate employee : company.getEmployees()) {
            System.out.println("Birthday: " + employee.getBirthday() + ", Name: " + employee.getName());
        }
    }

    /**
     * Prints a list of all companies connected to MyCompany.
     */
    public void printListOfAllCompanies(MyCompany myCompany) {
        int lister = 1;
        if (!(myCompany.getAssociatedCompanies() == null)) {
            System.out.println();
            for (Company company : myCompany.getAssociatedCompanies()) {
                System.out.println(lister + ". " + company.getName());
                lister++;
            }
        } else {
            System.out.println("No companies to connect to.");
        }
    }

    @Override
    public <T> void printInfo(T t) {
        if (t instanceof MyCompany) {
            System.out.println(((MyCompany) t).getName() + " Contact Info: ");
            System.out.println("Email: " + ((MyCompany) t).getContactInfo().getEmail());
            System.out.println("Phone Number: " + ((MyCompany) t).getContactInfo().getPhoneNumber());
            System.out.println("Address: " + ((MyCompany) t).getContactInfo().getAddress());
        }
    }

}