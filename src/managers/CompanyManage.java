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
            desiredCompanyName = getCompanyNameFromUserInput(businessAssociate, stringScanner);

            if (!objManage.getErrorManage().catchArrayListNullPointerException(myCompany.getBusinessAssociates())) {
                for (int i = 0; i < myCompany.getBusinessAssociates().size(); i++) {

                    currentCompanyName = myCompany.getBusinessAssociates().get(i).getCompany().getName();

                    if (currentCompanyName.toLowerCase().equals(desiredCompanyName.toLowerCase())) {
                        companyAlreadyExistWarning(currentCompanyName, businessAssociate);

                        userInputMenuChoice = objManage.getErrorManage().catchUserInputMismatchException(intScanner);

                        if (userInputMenuChoice == 1) {
                            return addCurrentBusinessAssociateToExistingCompany(myCompany, businessAssociate, currentCompanyName, i);
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

            } else {
                goAgain = false;
            }

        } while (goAgain);

        ContactInfo tempContactInfo = objManage.getContactInfoManage().createContactInfo(stringScanner);
        System.out.println();

        return new Company(desiredCompanyName, tempContactInfo);
    }

    private String getCompanyNameFromUserInput(String businessAssociate, Scanner stringScanner) {
        System.out.print("\nEnter some information about the company where " + businessAssociate + " works.\nName: ");
        return stringScanner.nextLine();
    }

    private Company addCurrentBusinessAssociateToExistingCompany(
            MyCompany myCompany,
            String businessAssociate,
            String currentCompanyName,
            int arrayIndexOfCompany) {
        System.out.println(businessAssociate + " added to " + currentCompanyName + ".");
        return myCompany.getBusinessAssociates().get(arrayIndexOfCompany).getCompany();
    }

    private void companyAlreadyExistWarning(String currentCompanyName, String businessAssociate) {
        System.out.println("Company " + currentCompanyName + " already exists!");
        System.out.print("Do you want to add " + businessAssociate + " to " + currentCompanyName + ", or change company? ");
        System.out.print("[1]Add to existing/[2]Change company: ");
    }

}