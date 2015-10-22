package managers;

import java.util.Scanner;

import companies.Company;
import contactInfo.ContactInfo;

public class CompanyManage {
	
	public Company createCompany(ObjectManage objManage, Scanner stringScanner) {
		System.out.print("Enter company name: ");
		String name = stringScanner.nextLine();
		ContactInfo tempContactInfo = objManage.contactInfoManage.createContactInfo(stringScanner);
		return new Company(name, tempContactInfo);
	}
}
