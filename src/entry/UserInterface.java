package entry;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import companies.Company;
import companies.Meeting;
import companies.MyCompany;
import contactInfo.ContactInfo;
import managers.ObjectManage;
import managers.PersonManage;
import managers.PrintManage;
import persons.Associate;

public class UserInterface {
	Scanner stringScanner = new Scanner(System.in);
	Scanner intScanner = new Scanner(System.in);
	ObjectManage objectManage = new ObjectManage();
	PrintManage printManage = new PrintManage();

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
			switch (input) {
			case "1":
				// Associate tempEmployee =
				// objectManage.getPersonManage().createAssociate(objectManage,
				// stringScanner, intScanner);
				Company tempcomp = new Company(null, null);
				ContactInfo tempcont = new ContactInfo(null, null, null);
				Associate test = new Associate(8, "test a", LocalDate.of(1931, 2, 23), tempcomp, "chef", tempcont);
				myCompany.addEmployee(test);
				myCompany.addEmployee(test);
				break;
			case "2":
				// Associate tempBusinessAssociate =
				// objectManage.getPersonManage().createAssociate(objectManage,
				// stringScanner, intScanner);
				Company temp2comp = new Company(null, null);
				ContactInfo temp2cont = new ContactInfo(null, null, null);
				Associate test2 = new Associate(8, "test a", LocalDate.of(1931, 2, 23), temp2comp, "chef", temp2cont);
				myCompany.addBusinessAssociate(test2);
				break;
			case "3":
				Meeting tempMeeting = objectManage.getMeetingManage().createMeeting(myCompany, objectManage,
						stringScanner, intScanner);
				if (myCompany.getMeetings() == null) {
					myCompany.createMeetings();
				}
				
				myCompany.getMeetings().add(tempMeeting);
				break;
			case "4":
				subMenuAssociate(input);
				printManage.getPrintPerson().printPersonList(myCompany.getEmployees());
				// TODO magic
				break;
			case "5":
				subMenuAssociate(input);
				printManage.getPrintPerson().printPersonList(myCompany.getBusinessAssociates());
				// TODO magic
				break;
			case "6":
				//subMenuMeeting();
				printManage.getPrintMeeting().printMeetingList(myCompany.getMeetings());
				break;
			case "7":
				System.out.println("Saving and logging off");
				menuOpen = false;
				break;
			default:
				break;
			}
		} while (menuOpen);
	}
	
	public void subMenuAssociate(String input) {
		switch(input) {
		case "1":
			break;
		case "2":
			break;
		default:
			break;	
		}
	}
	
	public void subMenuMeeting(String input) {
		switch(input) {
		case "1":
			break;
		case "2":
			break;
		default:
			break;	
		}
	}

}