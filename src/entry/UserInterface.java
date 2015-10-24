package entry;

import companies.*;
import contactInfo.ContactInfo;
import managers.ObjectManage;
import managers.PrintManage;
import menysystem.*;
import persons.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

	Scanner stringScanner = new Scanner(System.in);
	Scanner intScanner = new Scanner(System.in);
	ObjectManage objectManage = new ObjectManage();
	PrintManage printManage = new PrintManage();
	Menu menu = new ConsoleMenu();
	Menu subMenu = new ConsoleMenu();
	ArrayList<String> mainMenuAlternatives;
	ArrayList<String> subMenuAlternatives;

	int input;

	public void mainMenu(MyCompany myCompany) {

		// TODO RADERA DENNA KOD INNAN INLÄMNING! VÅRA TESTPERSONER LIGGER I
		// TESTKLASSEN! RADERA ÄVEN KLASS!(RADERA FRÅN MAPP ÅXÅ)
		TestKlassREMOVE testklassRemove = new TestKlassREMOVE();
		testklassRemove.TestKlass(myCompany);
		// TODO SLUT PÅ RADERING

		do {
			// MAIN MENU ALTERNATIVES
			menu.setMenuTitle("Main Menu");
			mainMenuAlternatives = new ArrayList<String>();
			mainMenuAlternatives.add("Create employee");
			mainMenuAlternatives.add("Create business contact");
			mainMenuAlternatives.add("Create meeting");
			mainMenuAlternatives.add("Manage employee");
			mainMenuAlternatives.add("Manage business contact");
			mainMenuAlternatives.add("Manage meeting");
			mainMenuAlternatives.add("Save & Quit system");

			// SUB MENU ALTERNATIVES
			subMenuAlternatives = new ArrayList<String>();
			subMenuAlternatives.add("Edit name");
			subMenuAlternatives.add("Edit birthdate");
			subMenuAlternatives.add("Edit address");
			subMenuAlternatives.add("Edit e-mail");
			subMenuAlternatives.add("Edit phonenumber");
			subMenuAlternatives.add("Edit familymembers");
			subMenuAlternatives.add("Edit position");

			menu.printMenu(mainMenuAlternatives);
			System.out.print("Choose option: ");
			input = menu.getInput(intScanner);
			mainSwitch(input, myCompany);
		} while (input != mainMenuAlternatives.size());
	}

	public void subMenuEmployee(int choice, MyCompany myCompany) {
		Associate currentPerson = myCompany.getEmployees().get(choice);

		subMenuAlternatives.add("Back to main menu");
		do {
			printManage.getPrintPerson().printInfo(currentPerson);
			subMenu.setMenuTitle("Edit and View Employee");
			subMenu.printMenu(subMenuAlternatives);
			System.out.print("Choose option: ");
			input = menu.getInput(intScanner);
			subMenuEmployeeSwitch(input, myCompany, currentPerson);
		} while (input != subMenuAlternatives.size());

	}

	public void subMenuBusinessAssociate(int choice, MyCompany myCompany) {
		Associate currentPerson = myCompany.getBusinessAssociates().get(choice);

		subMenuAlternatives.add("Edit company");
		subMenuAlternatives.add("Back to main menu");
		do {
			printManage.getPrintPerson().printInfo(currentPerson);
			subMenu.setMenuTitle("Edit and View Business associate");
			subMenu.printMenu(subMenuAlternatives);
			System.out.print("Choose option: ");
			input = menu.getInput(intScanner);
			subMenuBusinessSwitch(input, myCompany, currentPerson);
		} while (input != subMenuAlternatives.size());

	}

	public void mainSwitch(int input, MyCompany myCompany) {
		int choice;

		switch (input) {
		case 1:
			Associate tempEmployee = objectManage.getPersonManage().createEmployee(myCompany, objectManage,
					stringScanner);
			myCompany.addEmployee(tempEmployee);
			break;
		case 2:
			Associate tempBusinessAssociate = objectManage.getPersonManage().createBusinessAssociate(myCompany,
					objectManage, stringScanner, intScanner);
			myCompany.addBusinessAssociate(tempBusinessAssociate);
			break;
		case 3:
			// TODO
			// Ska det vara möjligt att skapa ett möte om man INTE har en
			// employee?
			// Ska det vara möjligt att skapa ett möte OM man har en employee,
			// men INTE business associate?
			// Isåfall måste vi ändra regler i create meeting
			// TODO SLUT
			if (myCompany.getEmployees() == null) {
				System.out.println("You dont have any employees yet");
				System.out.println("You can't create a meeting without any employees");
				System.out.println("Press any key to continue...");
				stringScanner.nextLine();
				break;
			} else if (myCompany.getBusinessAssociates() == null) {
				System.out.println("You dont have any business associets yet");
				System.out.println("Press any key to continue...");
				stringScanner.nextLine();
				break;
			}
			Meeting tempMeeting = objectManage.getMeetingManage().createMeeting(myCompany, objectManage, stringScanner,
					intScanner);
			if (myCompany.getMeetings() == null) {
				myCompany.createMeetings();
			}

			myCompany.getMeetings().add(tempMeeting);
			break;
		case 4:
			boolean loop = false;

			if (myCompany.getEmployees() == null) {
				System.out.println("You dont have any employees yet");
				System.out.println("Press any key to continue...");
				stringScanner.nextLine();
				break;
			}
			do {
				choice = removeOrView();

				switch (choice) {
				case 1:
					removeEmployee(myCompany);
					loop = false;
					break;
				case 2:
					editAndViewEmployee(input, myCompany);
					loop = false;
					break;
				case 3:
					// this option takes you back to the main menu. Leave blank.
					loop = false;
					break;
				default:
					System.out.println("Wrong choice! Try again!");
					loop = true;
					break;
				}
			} while (loop);
			break;
		case 5:
			boolean loop1 = false;

			if (myCompany.getBusinessAssociates() == null) {
				System.out.println("You dont have any business associets yet");
				System.out.println("Press any key to continue...");
				stringScanner.nextLine();
				break;
			}
			do {
				choice = removeOrView();

				switch (choice) {
				case 1:
					removeBusinessAssociate(myCompany);
					loop1 = false;
					break;
				case 2:
					editAndViewBusinessAssociation(input, myCompany);
					loop1 = false;
					break;
				case 3:
					// this option takes you back to the main menu. Leave blank.
					loop1 = false;
					break;
				default:
					System.out.println("Wrong choice! Try again!");
					loop1 = true;
					break;
				}
			} while (loop1);
		case 6:
			if (myCompany.getMeetings() == null) {
				System.out.println("You dont have any meetings yet");
				System.out.println("Press any key to continue...");
				stringScanner.nextLine();
				break;
			}
			choice = removeOrView();
			if (choice == 1) {
				// TODO här skall ett möte tas bort
				System.out.println("Här ska vi koda hur ett möte tas bort");
				break;
			}
			if (choice == 2) {
				editAndViewMeeting(myCompany);
				break;
			}
			if (choice == 3) {
				// this option takes you back to the main menu. Leave blank.
				break;
			}
			break;
		case 7:
			System.out.println("Saving and logging off");
			break;
		default:
			System.out.println("Wrong choice! Please try again!");
			break;
		}
	}

	public void subMenuEmployeeSwitch(int input, MyCompany myCompany, Associate currentPerson) {

		switch (input) {
		case 1:
			System.out.print("Set new name: ");
			String name = stringScanner.nextLine();
			currentPerson.setName(name);
			break;
		case 2:
			LocalDate birthDate = objectManage.getPersonManage().setBirthDate();
			currentPerson.setBirthDate(birthDate);
			break;
		case 3:
			System.out.print("Set new address: ");
			String address = stringScanner.nextLine();
			currentPerson.getContactInfo().setAddress(address);
			break;
		case 4:
			System.out.print("Set new email: ");
			String email = stringScanner.nextLine();
			email = objectManage.getContactInfoManage().setEmail(email, stringScanner);
			currentPerson.getContactInfo().setEmail(email);
			break;
		case 5:
			System.out.print("Set new phone number: ");
			String phoneNumber = stringScanner.nextLine();
			currentPerson.getContactInfo().setPhoneNumber(phoneNumber);
			break;
		case 6:
			System.out.println("Edit familymembers");
			// addOrViewFamily(currentPerson);
			break;
		case 7:
			System.out.println("Edit position");
			String position = stringScanner.nextLine();
			currentPerson.setPosition(position);
			break;
		case 8:
			// this option takes you back to the main menu. Leave blank.
			break;
		default:
			System.out.println("Wrong choice! Please try again!");
			break;
		}
	}

	public void subMenuBusinessSwitch(int input, MyCompany myCompany, Associate currentPerson) {

		switch (input) {
		case 1:
			System.out.print("Set new name: ");
			String name = stringScanner.nextLine();
			currentPerson.setName(name);
			break;
		case 2:
			LocalDate birthDate = objectManage.getPersonManage().setBirthDate();
			currentPerson.setBirthDate(birthDate);
			break;
		case 3:
			System.out.print("Set new address: ");
			String address = stringScanner.nextLine();
			currentPerson.getContactInfo().setAddress(address);
			break;
		case 4:
			System.out.print("Set new email: ");
			String email = stringScanner.nextLine();
			email = objectManage.getContactInfoManage().setEmail(email, stringScanner);
			currentPerson.getContactInfo().setEmail(email);
			break;
		case 5:
			System.out.print("Set new phone number: ");
			String phoneNumber = stringScanner.nextLine();
			currentPerson.getContactInfo().setPhoneNumber(phoneNumber);
			break;
		case 6:
			System.out.println("Edit familymembers");
			// addOrViewFamily(currentPerson);
			break;
		case 7:
			System.out.println("Edit position");
			String position = stringScanner.nextLine();
			currentPerson.setPosition(position);
			break;
		case 8:
			System.out.println("Edit company");
			// be able to change company on the business associate
			break;
		case 9:
			// this option takes you back to the main menu. Leave blank.
			break;
		default:
			System.out.println("Wrong choice! Please try again!");
			break;
		}
	}

	public void editAndViewEmployee(int choice, MyCompany myCompany) {
		printManage.getPrintPerson().printPersonList(myCompany.getEmployees());
		System.out.print("Choose employee: ");
		choice = menu.getInput(intScanner) - 1;
		subMenuEmployee(choice, myCompany);
	}

	public void editAndViewBusinessAssociation(int choice, MyCompany myCompany) {
		printManage.getPrintPerson().printPersonList(myCompany.getBusinessAssociates());
		System.out.print("Please choose business associate: ");
		choice = menu.getInput(intScanner) - 1;
		subMenuBusinessAssociate(choice, myCompany);
		// TODO magic
	}

	public void editAndViewMeeting(MyCompany myCompany) {
		boolean wrongChoice;

		printManage.getPrintMeeting().printMeetingList(myCompany.getMeetings());
		System.out.print("Choose meeting: ");
		input = menu.getInput(intScanner) - 1;
		Meeting currentMeeting = myCompany.getMeetings().get(input);
		printManage.getPrintMeeting().printInfo(currentMeeting);
		do {
			System.out.print("Do you want to create a journal? (1)Yes/(2)No: ");
			input = menu.getInput(intScanner);
			switch (input) {
			case 1:
				ArrayList<String> protocol = objectManage.getMeetingManage().createProtocol(stringScanner, intScanner);
				Journal tempJournal = new Journal(protocol);
				currentMeeting.setJournal(tempJournal);
				wrongChoice = false;
				break;
			case 2:
				// this option takes you back to the main menu. Leave blank.
				wrongChoice = false;
				break;
			default:
				System.out.println("Wrong choice! Try again!");
				wrongChoice = true;
				break;
			}
		} while (wrongChoice);
	}

	public void removeEmployee(MyCompany myCompany) {
		// Här ska en person sparas i past employees och sen raderas!
		System.out.println("Employee removed");
	}

	public void removeBusinessAssociate(MyCompany myCompany) {
		// Här ska väl en Business associate sparas i nån past array, och sen
		// slängas?
		System.out.println("Business associate removed");
	}

	public int removeOrView() {
		System.out.println("1. Remove");
		System.out.println("2. Edit and View");
		System.out.println("3. Go Back");
		System.out.print("Choose option: ");
		input = menu.getInput(intScanner);
		return input;
	}

	/*
	 * public void addOrViewFamily(Associate currentPerson) { boolean
	 * failedInput = true;
	 * 
	 * if (currentPerson.getFamilyMembers() == null) { FamilyMember family = new
	 * FamilyMember(); } do { System.out.println("1. Add companion");
	 * System.out.println("2. Add child"); System.out.println("3. Edit and View"
	 * ); System.out.print("Choose option: "); input =
	 * menu.getInput(intScanner);
	 * 
	 * if (input == 1) { System.out.print("Enter name: "); String name =
	 * stringScanner.nextLine(); LocalDate birthDate =
	 * objectManage.getPersonManage().setBirthDate();
	 * 
	 * FamilyMember companion = new FamilyMember(1, name, birthDate);
	 * 
	 * currentPerson.getFamilyMembers().add(companion);
	 * 
	 * failedInput = false; } else if (input == 2) { System.out.print(
	 * "Enter name: "); String name = stringScanner.nextLine(); LocalDate
	 * birthDate = objectManage.getPersonManage().setBirthDate();
	 * 
	 * if (currentPerson.getFamily().getChildren() == null) {
	 * currentPerson.getFamily().createChildrenArray(); }
	 * 
	 * Person child = new Person(2, name, birthDate);
	 * currentPerson.getFamily().addChild(child);
	 * 
	 * failedInput = false; } else if (input == 3) {
	 * 
	 * failedInput = false; } else {
	 * 
	 * System.out.println("Wrong input, try again.");
	 * 
	 * } } while (failedInput); }
	 */
}