package printers;

import companies.MyCompany;
import persons.Associate;

public class PrintCompany implements PrintManage {

	public void printName(MyCompany company) {
		System.out.println("Company Name: " + company.getName());
	}
	public void printEmployees(MyCompany company) {
		for (Associate employee : company.getEmployees()) {
			System.out.println("Birthday: " + employee.getBirthday() + ", Name: " + employee.getName());
		}
	}

	@Override
	public <T> void printInfo(T t) {
		if (t instanceof MyCompany) {
			System.out.println(((MyCompany) t).getName() + " Contact Info: ");
			System.out.println("Email: " + ((MyCompany) t).getContactInfo().getEmail());
			System.out.println("Phone Number: " + ((MyCompany) t).getContactInfo().getPhoneNumber());
			System.out.println("Address: " + ((MyCompany) t).getContactInfo().getAddress());
		}
	}

}