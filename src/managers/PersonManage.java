package managers;

import java.time.LocalDate;
import java.util.Scanner;

import companies.MyCompany;
import contactInfo.ContactInfo;
import persons.Associate;

public class PersonManage {
	
	public Associate createAssociate(Scanner stringScanner, Scanner intScanner){
		int id = 0;
		System.out.print("Enter name: ");
		String name = stringScanner.nextLine();
		LocalDate birthDate = setBirthDate(intScanner);
		
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
