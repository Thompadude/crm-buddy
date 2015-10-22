package managers;

import companies.Company;
import contactInfo.ContactInfo;
import persons.Associate;

import java.time.LocalDate;
import java.util.Scanner;

public class PersonManage {

    public Associate createAssociate(ObjectManage objManage, Scanner stringScanner, Scanner intScanner) {
        int id = 0;
        System.out.print("Enter name: ");
        String name = stringScanner.nextLine();
        LocalDate birthDate = setBirthDate(intScanner);
        Company company = objManage.companyManage.createCompany(objManage, stringScanner);
        System.out.print("Please enter position: ");
        String position = stringScanner.nextLine();
        ContactInfo contactInfo = objManage.contactInfoManage.createContactInfo(stringScanner);
        return new Associate(id, name, birthDate, company, position, contactInfo);
    }

    public LocalDate setBirthDate(Scanner intScanner) {
        System.out.print("Enter birthyear(YYYY): ");
        int year = intScanner.nextInt();
        System.out.print("Enter month(MM): ");
        int month = intScanner.nextInt();
        System.out.print("Enter day(DD): ");
        int day = intScanner.nextInt();
        return LocalDate.of(year, month, day);
    }

}