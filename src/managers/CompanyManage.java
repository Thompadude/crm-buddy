package managers;

import companies.Company;
import companies.MyCompany;
import contactInfo.ContactInfo;

import java.util.Scanner;

public class CompanyManage {

    protected Company createCompany(MyCompany myCompany, ObjectManage objManage, Scanner stringScanner, String businessAssociate) {
        System.out.print("\nPlease enter some information about the company where " + businessAssociate + " works.\nName: ");
        String desiredCompanyName = stringScanner.nextLine();
        if (!(myCompany.getBusinessAssociates() == null)) {
            for (int i = 0; i < myCompany.getBusinessAssociates().size(); i++) {
                String checkIfCompanyNameExists = myCompany.getBusinessAssociates().get(i).getCompany().getName();
                while (checkIfCompanyNameExists.toLowerCase().equals(desiredCompanyName.toLowerCase())) {
                    System.out.print("Company name already exists! Please choose another name: ");
                    desiredCompanyName = stringScanner.nextLine();
                    i = 0;
                }
            }
        }
        ContactInfo tempContactInfo = objManage.contactInfoManage.createContactInfo(stringScanner);
        System.out.println();
        return new Company(desiredCompanyName, tempContactInfo);
    }

}