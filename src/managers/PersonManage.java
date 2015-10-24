package managers;

import companies.Company;
import companies.MyCompany;
import contactInfo.ContactInfo;
import persons.Associate;
import persons.Family;
import persons.FamilyMember;

import java.time.LocalDate;
import java.util.Scanner;

public class PersonManage {

    public Associate createEmployee(MyCompany myCompany, ObjectManage objManage, Scanner stringScanner) {
        System.out.println("You have chosen to create a new employee.");
        String name = getNameFromUserInput(stringScanner);
        ObjectManage objectManage = new ObjectManage();
        LocalDate birthDate = objectManage.getDateManage().getBirthDateFromUserInput();
        Company tempCompany = new Company(myCompany.getName(), myCompany.getContactInfo());
        System.out.print("Enter position: ");
        String position = stringScanner.nextLine();
        ContactInfo contactInfo = objManage.getContactInfoManage().createContactInfo(stringScanner);
        System.out.println("\nNew employee " + name + " created!\n");
        return new Associate(name, birthDate, tempCompany, position, contactInfo);
    }

    public Associate createBusinessAssociate(MyCompany myCompany, ObjectManage objManage, Scanner stringScanner, Scanner intScanner) {
        System.out.print("You have chosen to create a new business associate.");
        String name = getNameFromUserInput(stringScanner);
        ObjectManage objectManage = new ObjectManage();
        LocalDate birthDate = objectManage.getDateManage().getBirthDateFromUserInput();
        System.out.print("Enter position: ");
        String position = stringScanner.nextLine();
        ContactInfo contactInfo = objManage.getContactInfoManage().createContactInfo(stringScanner);
        System.out.println("\nDo you want to add " + name + " to a existing company or create a new one?");
        System.out.println("\n1. Existing");
        System.out.println("2. Create New");
        System.out.print("\nChoose an option: ");
        int input = objManage.getErrorManage().catchUserInputMismatchException(intScanner);
        Company company;
        if (input == 1) {
            PrintManage printManage = new PrintManage();
            printManage.getPrintCompany().printListOfAllCompanies(myCompany);
            System.out.print("\nChoose company ID: ");
            while (true) {
                input = objManage.getErrorManage().catchUserInputMismatchException(intScanner) - 1;
                if (input >= myCompany.getAssociatedCompanies().size()) {
                    System.out.print("Wrong input. Try again: ");
                } else {
                    company = myCompany.getAssociatedCompanies().get(input);
                    break;
                }
            }
        } else {
            company = objManage.getCompanyManage().createCompany(myCompany, objManage, stringScanner, name);
            myCompany.addAssociatedCompany(company);
        }
        System.out.println("New business associate " + name + " from " + company.getName() + " created!\n");
        return new Associate(name, birthDate, company, position, contactInfo);
    }

    public FamilyMember createFamilyMember(Scanner stringScanner) {
        System.out.println("You have chosen to create a new family member.");
        String name = getNameFromUserInput(stringScanner);
        System.out.println("1. Spouse\n2. Child");
        System.out.print("Choose if it is your spouse or child: ");
        Family family = null;
        while (family == null) {
            String familyType = stringScanner.nextLine();
            switch (familyType) {
                case "1":
                    family = Family.SPOUSE;
                    break;
                case "2":
                    family = Family.CHILD;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        ObjectManage objectManage = new ObjectManage();
        LocalDate localDate = objectManage.getDateManage().getBirthDateFromUserInput();
        FamilyMember familyMember = new FamilyMember(name, localDate, family);
        return familyMember;
    }

    private String getNameFromUserInput(Scanner stringScanner) {
        System.out.print("\nEnter name: ");
        return stringScanner.nextLine();
    }

}