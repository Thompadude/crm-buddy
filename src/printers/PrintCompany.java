package printers;

import companies.Company;
import persons.Associate;

public class PrintCompany implements PrintManage {

	public void printName(Company company) {
		System.out.println("Company Name: " + company.getName());
	}

	// public void printContactInfo(Company company) {
	// System.out.println("Company Contact Info: ");
	// System.out.println("Email: " + company.getContactInfo().getEmail());
	// System.out.println("Phone Number: " +
	// company.getContactInfo().getPhoneNumber());
	// System.out.println("Address: " + company.getContactInfo().getAddress());
	// }

	public void printEmployees(Company company) {
		for (Associate employee : company.getEmployees()) {
			System.out.println("Birthday: " + employee.getBirthday() + ", Name: " + employee.getName());
		}
	}

	@Override
	public <T> void printContactInfo(T t) {
		if (t instanceof Company) {
			System.out.println(((Company) t).getName() + " Contact Info: ");
			System.out.println("Email: " + ((Company) t).getContactInfo().getEmail());
			System.out.println("Phone Number: " + ((Company) t).getContactInfo().getPhoneNumber());
			System.out.println("Address: " + ((Company) t).getContactInfo().getAddress());
		}
	}

}