package managers;

import companies.Company;
import companies.MyCompany;
import contactInfo.ContactInfo;
import menysystem.ConsoleMenu;
import persons.Associate;
import persons.Family;
import persons.FamilyMember;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class PersonManage {

    public Associate createEmployee(MyCompany myCompany, ObjectManage objManage, Scanner stringScanner) {
        System.out.println("You have chosen to create a new employee.");
        String name = getNameFromUserInput(stringScanner);
        LocalDate birthDate = getBirthDateFromUserInput();
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
        LocalDate birthDate = getBirthDateFromUserInput();
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
        LocalDate localDate = getBirthDateFromUserInput();
        FamilyMember familyMember = new FamilyMember(name, localDate, family);
        return familyMember;
    }

    public LocalDate getBirthDateFromUserInput() {
        LocalDate localDate;
        Scanner intScanner;
        int year, month, day;
        String wrongInput = "Wrong input. Please use correct format: ";
        System.out.print("Enter birth year (YYYY): ");
        while (true) {
            try {
                intScanner = new Scanner(System.in);
                year = intScanner.nextInt();
                while (year < 1000 || year > 9999) {
                    System.out.print(wrongInput);
                    year = intScanner.nextInt();
                }
                break;
            } catch (Exception e) {
                System.out.print(wrongInput);
            }
        }
        System.out.print("Enter birth month (MM): ");
        while (true) {
            try {
                intScanner = new Scanner(System.in);
                month = intScanner.nextInt();
                while (month < 1 || month > 12) {
                    System.out.print(wrongInput);
                    month = intScanner.nextInt();
                }
                break;
            } catch (Exception e) {
                System.out.print(wrongInput);
            }
        }
        while (true) {
            while (true) {
                try {
                    System.out.print("Enter birth day (DD): ");
                    intScanner = new Scanner(System.in);
                    day = intScanner.nextInt();
                    while (day < 1 || day > 31) {
                        System.out.print(wrongInput);
                        day = intScanner.nextInt();
                    }
                    break;
                } catch (Exception e) {
                    System.out.print(wrongInput);
                }
            }
            try {
                localDate = LocalDate.of(year, month, day);
                break;
            } catch (DateTimeException e) {
                System.out.println(e);
            }
        }
        return localDate;
    }

    private String getNameFromUserInput(Scanner stringScanner) {
        System.out.print("Enter name: ");
        return stringScanner.nextLine();
    }

}