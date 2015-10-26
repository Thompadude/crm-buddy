package managers;

import companies.Company;
import companies.MyCompany;
import contactInfo.ContactInfo;

import java.util.Scanner;

public class CompanyManage {

    protected Company createCompany(MyCompany myCompany, ObjectManage objManage, Scanner stringScanner, Scanner intScanner, String businessAssociate) {
        boolean goAgain = true;
        String desiredCompanyName;
        int userInputMenuChoice;
        String currentCompanyName;
        do {
            System.out.print("\nEnter some information about the company where " + businessAssociate + " works.\nName: ");
            desiredCompanyName = stringScanner.nextLine();
            if (!objManage.getErrorManage().catchArrayListNullPointerException(myCompany.getBusinessAssociates())) {
                for (int i = 0; i < myCompany.getBusinessAssociates().size(); i++) {
                    currentCompanyName = myCompany.getBusinessAssociates().get(i).getCompany().getName();
                    if (currentCompanyName.toLowerCase().equals(desiredCompanyName.toLowerCase())) {
                        System.out.println("Company " + currentCompanyName + " already exists!");
                        System.out.print("Do you want to add " + businessAssociate + " to " + currentCompanyName + ", or change company? ");
                        System.out.print("[1]Add to existing/[2]Change company: ");
                        userInputMenuChoice = objManage.getErrorManage().catchUserInputMismatchException(intScanner);
                        if (userInputMenuChoice == 1) {
                            System.out.println(businessAssociate + " added to " + currentCompanyName + ".");
                            Company company = myCompany.getBusinessAssociates().get(i).getCompany();
                            return company;
                        } else if (userInputMenuChoice == 2) {
                            i = myCompany.getBusinessAssociates().size();
                            goAgain = true;
                        } else {
                            System.out.println("Wrong input. Try again.");
                            i = 0;
                            goAgain = false;
                        }
                    } else {
                        goAgain = false;
                    }
                }
            }
        } while (goAgain);
        ContactInfo tempContactInfo = objManage.getContactInfoManage().createContactInfo(stringScanner);
        System.out.println();
        return new Company(desiredCompanyName, tempContactInfo);
    }

}