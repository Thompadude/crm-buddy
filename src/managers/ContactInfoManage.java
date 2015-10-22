package managers;

import contactInfo.ContactInfo;

import java.util.Scanner;

public class ContactInfoManage {

    public ContactInfo createContactInfo(Scanner stringScanner) {
        System.out.print("Enter email: ");
        String email = stringScanner.nextLine();
        while (!email.contains("@")) {
            System.out.print("That's not a valid email address. Please include an \"@\": ");
            email = stringScanner.nextLine();
        }
        System.out.print("Enter address: ");
        String address = stringScanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = stringScanner.nextLine();
        return new ContactInfo(email, address, phoneNumber);
    }

}