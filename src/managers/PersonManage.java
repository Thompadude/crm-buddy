package managers;

import companies.Company;
import companies.MyCompany;
import contactInfo.ContactInfo;
import persons.Associate;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class PersonManage {

    public Associate createEmployee(MyCompany myCompany, ObjectManage objManage, Scanner stringScanner, Scanner intScanner) {
        int id = 0;
        System.out.print("Enter name: ");
        String name = stringScanner.nextLine();
        LocalDate birthDate = setBirthDate();
        Company tempCompany = new Company(myCompany.getName(), myCompany.getContactInfo());
        System.out.print("Please enter position: ");
        String position = stringScanner.nextLine();
        ContactInfo contactInfo = objManage.contactInfoManage.createContactInfo(stringScanner);
        return new Associate(id, name, birthDate, tempCompany, position, contactInfo);
    }

    public Associate createBusinessAssociate(ObjectManage objManage, Scanner stringScanner, Scanner intScanner) {
        int id = 0;
        System.out.print("Enter name: ");
        String name = stringScanner.nextLine();
        LocalDate birthDate = setBirthDate();
        Company company = objManage.companyManage.createCompany(objManage, stringScanner);
        System.out.print("Please enter position: ");
        String position = stringScanner.nextLine();
        ContactInfo contactInfo = objManage.contactInfoManage.createContactInfo(stringScanner);
        return new Associate(id, name, birthDate, company, position, contactInfo);
    }

    public LocalDate setBirthDate() {
        LocalDate localDate = null;
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

}