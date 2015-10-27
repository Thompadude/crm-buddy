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
    public boolean printListOfAllCompanies(MyCompany myCompany) {
        int lister = 1;

        if (!(myCompany.getAssociatedCompanies() == null)) {
            System.out.println();

            for (Company company : myCompany.getAssociatedCompanies()) {
                System.out.println(lister + ". " + company.getName());
                lister++;
            }

            return true;
        } else {
            System.out.println("No companies to connect to.");

            return false;
        }
    }

    @Override
    public <T> void printInfo(T t) {
        if (t instanceof Company) {
            System.out.println(((Company) t).getName() + " Contact Info: ");
            System.out.println("Email: " + ((Company) t).getContactInfo().getEmail());
            System.out.println("Phone Number: " + ((Company) t).getContactInfo().getPhoneNumber());
            System.out.println("Address: " + ((Company) t).getContactInfo().getAddress());
        }
    }

}