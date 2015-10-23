package managers;

import java.util.Scanner;

import companies.Company;
import contactInfo.ContactInfo;

public class CompanyManage {
	
	public Company createCompany(ObjectManage objManage, Scanner stringScanner, String businessAssociate) {
		System.out.print("\nPlease enter som information about the company where " + businessAssociate + " works.\nName: ");
		String name = stringScanner.nextLine();
		ContactInfo tempContactInfo = objManage.contactInfoManage.createContactInfo(stringScanner);
		System.out.println();
		return new Company(name, tempContactInfo);
	}
}