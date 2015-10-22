package entry;

import java.util.Scanner;

import companies.Meeting;
import companies.MyCompany;
import managers.ObjectManage;
import managers.PersonManage;
import persons.Associate;

public class UserInterface {
	Scanner stringScanner = new Scanner(System.in);
	Scanner intScanner = new Scanner(System.in);
	ObjectManage objectManage = new ObjectManage();
	
	private void menuText() {
		System.out.println("Welcome to CRM");
		System.out.println("Please choose one of the following alternatives:");
		System.out.println("1. Create employee");
		System.out.println("2. Create business contact");
		System.out.println("3. Create meeting");
		System.out.println("4. Edit/View employee");
		System.out.println("5. Edit/View business contact");
		System.out.println("6. Edit/View meeting");
		System.out.println("7. Save settings & Log off");
	}
	
	public void menuChoice(MyCompany myCompany) {
		boolean menuOpen = true;
		do {
			menuText();
			String input = stringScanner.nextLine();
			switch(input) {
			case "1":
				Associate tempEmployee = objectManage.getPersonManage().createAssociate(objectManage, stringScanner, intScanner);
				myCompany.addEmployee(tempEmployee);
				break;
			case "2":
				Associate tempBusinessAssociate = objectManage.getPersonManage().createAssociate(objectManage, stringScanner, intScanner);
				myCompany.addBusinessAssociate(tempBusinessAssociate);
				break;
			case "3":
				Meeting tempMeeting = objectManage.getMeetingManage().createMeeting()
				break;
			case "4":
				break;
			case "5":
				break;
			case "6":
				break;
			case "7":
				System.out.println("Saving and logging off");
				menuOpen = false;
				break;
			}
		} while (menuOpen);
	}

}