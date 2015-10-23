package printers;

import companies.Company;
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
        ArrayList<String> checkIfCompanyAlreadyPrinted = new ArrayList<>();
        // Metoden trasig. Ska lagas.

        boolean print = true;
        System.out.println("Company ID\tName");
        for (int i = 0; i<myCompany.getBusinessAssociates().size(); i++) {

            if (!checkIfCompanyAlreadyPrinted.equals(myCompany.getBusinessAssociates().get(i).getCompany().getName())) {
                System.out.println(i + "\t" + myCompany.getBusinessAssociates().get(i).getCompany().getName());
                checkIfCompanyAlreadyPrinted.add(myCompany.getBusinessAssociates().get(i).getCompany().getName());
            }


        }

//        boolean print = true;
//        ArrayList<Company> tempCompanies = new ArrayList<>();
//        if (!(myCompany.getBusinessAssociates() == null)) {
//            for (int i = 0; i < myCompany.getBusinessAssociates().size(); i++) {
//                Company companyToPrint = myCompany.getBusinessAssociates().get(i).getCompany();
//                for (int j = 0; j < tempCompanies.size(); j++) {
//                    if (tempCompanies.get(j).equals(companyToPrint)) {
//                        print = false;
//                        break;
//                    }
//                }
//                if (print) {
//                    System.out.println(i + ". " + companyToPrint.getName());
//                    tempCompanies.add(companyToPrint);
//                }
//            }
//        }
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