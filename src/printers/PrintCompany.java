package printers;

import companies.MyCompany;
import persons.Associate;

import java.util.ArrayList;

public class PrintCompany implements Printable {

    public void printName(MyCompany company) {
        System.out.println("Company Name: " + company.getName());
    }

    public void printEmployees(MyCompany company) {
        for (Associate employee : company.getEmployees()) {
            System.out.println("Birthday: " + employee.getBirthday() + ", Name: " + employee.getName());
        }
    }

    public void printListOfAllCompanies(MyCompany myCompany) {
        if (!(myCompany.getBusinessAssociates() == null)) {
            for (int i = 0; i < myCompany.getBusinessAssociates().size(); i++) {
                ArrayList<String> companyNameAlreadyPrinted = new ArrayList<>();
                String companyNameToPrint;
                companyNameToPrint = myCompany.getBusinessAssociates().get(i).getCompany().getName();
                if (!companyNameToPrint.equals(companyNameAlreadyPrinted)) {
                    System.out.println(companyNameToPrint);
                    companyNameAlreadyPrinted.add(companyNameToPrint);
                }
            }
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