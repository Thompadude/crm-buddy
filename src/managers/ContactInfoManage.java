package managers;

import java.util.Scanner;

import contactInfo.ContactInfo;

public class ContactInfoManage {
	
	public ContactInfo createContactInfo(Scanner stringScanner) {
		System.out.print("Enter email: ");
		String email = stringScanner.nextLine();
		System.out.print("Enter address: ");
		String address = stringScanner.nextLine();
		System.out.print("Enter phonenumber: ");
		String phoneNumber = stringScanner.nextLine();
		
		return new ContactInfo(email, address, phoneNumber); 
	}
}
