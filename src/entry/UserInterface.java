package entry;


import java.util.ArrayList;
import java.util.Scanner;

import companies.*;
import managers.ObjectManage;
import managers.PrintManage;
import menysystem.*;
import persons.Associate;

public class UserInterface {

	Scanner stringScanner = new Scanner(System.in);
	Scanner intScanner = new Scanner(System.in);
	ObjectManage objectManage = new ObjectManage();
	PrintManage printManage = new PrintManage();
	Menu menu = new ConsoleMenu();
	Menu subMenuEmployee = new ConsoleMenu();
	Menu subMenuAssociate = new ConsoleMenu();
	Menu subMenuMeeting = new ConsoleMenu();
	ArrayList<String> menuAlternatives;
	
	
	
	public void mainMenu(MyCompany myCompany) {
		menu.setMenuTitle("Welcome to CRM");

		menuAlternatives = new ArrayList<String>();
		menuAlternatives.add("Create employee");
		menuAlternatives.add("Create business contact");
		menuAlternatives.add("Create meeting");
		menuAlternatives.add("Edit/view employee");
		menuAlternatives.add("Edit/view business contact");
		menuAlternatives.add("Edit/view meeting");

		int input = 0;
				
		do {
			menu.printMenu(menuAlternatives);
			input = menu.getInput(intScanner);
			mainSwitch(input, myCompany);
		} while (input != menuAlternatives.size() + 1);
	}
	
	public void subMenuEmployee(MyCompany myCompany) {
		menu.setMenuTitle("Edit and View Employee");

		menuAlternatives = new ArrayList<String>();
		menuAlternatives.add("1");
		menuAlternatives.add("2");
		menuAlternatives.add("3");
		menuAlternatives.add("4");
		menuAlternatives.add("5");
		menuAlternatives.add("6");
		menuAlternatives.add("Back to main menu");

		int input = 0;
		
		do {
			menu.printMenu(menuAlternatives);
			input = menu.getInput(intScanner);
			subMenuEmployeeSwitch(input, myCompany);
			} while (input != menuAlternatives.size() + 1);

	}
	
	public void subMenuBusinessAssociate(MyCompany myCompany) {
		menu.setMenuTitle("Edit and View Business associate");

		menuAlternatives = new ArrayList<String>();
		menuAlternatives.add("bizznizz");
		menuAlternatives.add("bizznizz");
		menuAlternatives.add("bizznizz");
		menuAlternatives.add("bizznizz");
		menuAlternatives.add("bizznizz");
		menuAlternatives.add("bizznizz");
		menuAlternatives.add("Back to main menu");

		int input = 0;
		
		do {
			menu.printMenu(menuAlternatives);
			input = menu.getInput(intScanner);
			subMenuEmployeeSwitch(input, myCompany);
			} while (input != menuAlternatives.size() + 1);

	}
	
	public void subMenuMeeting(MyCompany myCompany) {
		menu.setMenuTitle("Edit and View Meeting");

		menuAlternatives = new ArrayList<String>();
		menuAlternatives.add("meeting");
		menuAlternatives.add("meeting");
		menuAlternatives.add("meeting");
		menuAlternatives.add("meeting");
		menuAlternatives.add("meeting");
		menuAlternatives.add("meeting");
		menuAlternatives.add("Back to main menu");

		int input = 0;
		
		do {
			menu.printMenu(menuAlternatives);
			input = menu.getInput(intScanner);
			subMenuMeetingSwitch(input, myCompany);
			} while (input != menuAlternatives.size() + 1);

	}
	
	public void mainSwitch(int input, MyCompany myCompany) {
		switch (input) {
		case 1:
			createEmployee(myCompany);
			break;
		case 2:
			createBusinessAssociate(myCompany);
			break;
		case 3:
			createMeeting(myCompany);
			break;
		case 4:
			editAndViewEmployee(input, myCompany);
			break;
		case 5:
			editAndViewBusinessAssociation(input, myCompany);
			break;
		case 6:
			editAndViewMeeting(myCompany);
			break;
		case 7:
			System.out.println("Saving and logging off");
			break;
		default:
			System.out.println("Wrong choice! Please try again!");
			break;
		}
	}
	
	public void subMenuEmployeeSwitch(int input, MyCompany myCompany) {
		switch (input) {
		case 1:
			System.out.println("testar case 1");
			break;
		case 2:
			System.out.println("testar case 2");
			break;
		case 3:
			System.out.println("testar case 3");
			break;
		case 4:
			System.out.println("testar case 4");
			break;
		case 5:
			System.out.println("testar case 5");
			break;
		case 6:
			System.out.println("testar case 6");
			break;
		case 7:
			mainMenu(myCompany);
			break;
		default:
			System.out.println("Wrong choice! Please try again!");
			break;
		}
	}
	
	public void subMenuBusinessSwitch(int input, MyCompany myCompany) {
		switch (input) {
		case 1:
			System.out.println("testar case 1");
			break;
		case 2:
			System.out.println("testar case 2");
			break;
		case 3:
			System.out.println("testar case 3");
			break;
		case 4:
			System.out.println("testar case 4");
			break;
		case 5:
			System.out.println("testar case 5");
			break;
		case 6:
			System.out.println("testar case 6");
			break;
		case 7:
			mainMenu(myCompany);
			break;
		default:
			System.out.println("Wrong choice! Please try again!");
			break;
		}
	}
	
	public void subMenuMeetingSwitch(int input, MyCompany myCompany) {
		switch (input) {
		case 1:
			System.out.println("testar case 1");
			break;
		case 2:
			System.out.println("testar case 2");
			break;
		case 3:
			System.out.println("testar case 3");
			break;
		case 4:
			System.out.println("testar case 4");
			break;
		case 5:
			System.out.println("testar case 5");
			break;
		case 6:
			System.out.println("testar case 6");
			break;
		case 7:
			mainMenu(myCompany);
			break;
		default:
			System.out.println("Wrong choice! Please try again!");
			break;
		}
	}



	public void createEmployee(MyCompany myCompany) {
		Associate tempEmployee = objectManage.getPersonManage().createEmployee(myCompany, objectManage, stringScanner,
				intScanner);
		myCompany.addEmployee(tempEmployee);
	}

	public void createBusinessAssociate(MyCompany myCompany) {
		Associate tempBusinessAssociate = objectManage.getPersonManage().createBusinessAssociate(objectManage,
				stringScanner, intScanner);
		myCompany.addBusinessAssociate(tempBusinessAssociate);
	}

	public void createMeeting(MyCompany myCompany) {
		Meeting tempMeeting = objectManage.getMeetingManage().createMeeting(myCompany, objectManage, stringScanner,
				intScanner);
		if (myCompany.getMeetings() == null) {
			myCompany.createMeetings();
		}

		myCompany.getMeetings().add(tempMeeting);
	}

	public void editAndViewEmployee(int input, MyCompany myCompany) {
		subMenuEmployee(myCompany);
		printManage.getPrintPerson().printPersonList(myCompany.getEmployees());
		// TODO magic
	}

	public void editAndViewBusinessAssociation(int input, MyCompany myCompany) {
		
		if (myCompany.getBusinessAssociates() == null) {
			System.out.println("You dont have any business associets yet");
			System.out.println("Press any key to continue...");
			stringScanner.nextLine();
		} else {
		printManage.getPrintPerson().printPersonList(myCompany.getBusinessAssociates());
		}
		// TODO magic
	}

	public void editAndViewMeeting(MyCompany myCompany) {
		// subMenuMeeting();
		printManage.getPrintMeeting().printMeetingList(myCompany.getMeetings());
	}
}