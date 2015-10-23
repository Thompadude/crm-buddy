package entry;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import companies.*;
import managers.ObjectManage;
import managers.PrintManage;
import menysystem.*;
import persons.Associate;
import persons.FamilyMembers;
import persons.Person;
import printers.PrintPerson;

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

	private void welcomeText() {
		System.out.println("\n\t*************************************************\t\t\n\t*"
				+ "\t\t\t\t\t\t\t\t\t\t\t\t*\n\t*\t\t\tWELCOME to CRM Buddy 2.0\t\t\t*"
				+ "\n\t*\t\t\t\t\t\t\t\t\t\t\t\t*\n\t************************************************"
				+ "*\n\n\t\t\tPress ENTER to continue...");
		stringScanner.nextLine();
	}

	public void mainMenu(MyCompany myCompany) {
		welcomeText();
		menu.setMenuTitle("Main Menu");

		menuAlternatives = new ArrayList<String>();
		menuAlternatives.add("Create employee");
		menuAlternatives.add("Create business contact");
		menuAlternatives.add("Create meeting");
		menuAlternatives.add("Manage employee");
		menuAlternatives.add("Manage business contact");
		menuAlternatives.add("Manage meeting");

		int input = 0;

		do {
			menu.printMenu(menuAlternatives);
			input = menu.getInput(intScanner);
			mainSwitch(input, myCompany);
		} while (input != menuAlternatives.size() + 1);
	}

	public void subMenuEmployee(int choice, MyCompany myCompany) {
		Associate currentPerson = myCompany.getEmployees().get(choice);

		menu.setMenuTitle("Edit and View Employee");
		printManage.getPrintPerson().printInfo(currentPerson);
		menuAlternatives = new ArrayList<String>();
		menuAlternatives.add("Edit name");
		menuAlternatives.add("Edit birthdate");
		menuAlternatives.add("Edit address");
		menuAlternatives.add("Edit e-mail");
		menuAlternatives.add("Edit phonenumber");
		menuAlternatives.add("Edit familymembers");
		menuAlternatives.add("Edit position");
		menuAlternatives.add("Back to main menu");

		int input = 0;

		do {
			if (myCompany.getEmployees() == null) {
				System.out.println("You dont have any employees yet");
				System.out.println("Press any key to continue...");
				stringScanner.nextLine();
			} else {
				menu.printMenu(menuAlternatives);
				input = menu.getInput(intScanner);
				subMenuEmployeeSwitch(input, myCompany, currentPerson);
			}
		} while (input != menuAlternatives.size() + 1);

	}

	public void subMenuBusinessAssociate(int choice, MyCompany myCompany) {
		Associate currentPerson = myCompany.getEmployees().get(choice);

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
			subMenuBusinessSwitch(input, myCompany);
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
			Associate tempEmployee = objectManage.getPersonManage().createEmployee(myCompany, objectManage,
					stringScanner, intScanner);
			myCompany.addEmployee(tempEmployee);
			break;
		case 2:
			Associate tempBusinessAssociate = objectManage.getPersonManage().createBusinessAssociate(objectManage,
					stringScanner, intScanner);
			myCompany.addBusinessAssociate(tempBusinessAssociate);
			break;
		case 3:
			Meeting tempMeeting = objectManage.getMeetingManage().createMeeting(myCompany, objectManage, stringScanner,
					intScanner);
			if (myCompany.getMeetings() == null) {
				myCompany.createMeetings();
			}

			myCompany.getMeetings().add(tempMeeting);
			break;
		case 4:
			if (removeOrView(input) == 1) {
				removeEmployee(myCompany);
			} else {
				editAndViewEmployee(input, myCompany);
			}
			break;
		case 5:
			if (removeOrView(input) == 1) {
				removeBusinessAssociate(myCompany);
			} else {
				editAndViewBusinessAssociation(input, myCompany);
			}
			break;
		case 6:
			if (removeOrView(input) == 1) {
				removeEmployee(myCompany);
			} else {
				editAndViewMeeting(myCompany);
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
			addOrViewFamily(currentPerson);
			break;
		case 7:
			System.out.println("Edit position");
			String position = stringScanner.nextLine();
			currentPerson.setPosition(position);
			break;
		case 8:
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

	public void editAndViewEmployee(int choice, MyCompany myCompany) {
		if (myCompany.getEmployees() == null) {
			System.out.println("You dont have any employees yet");
			System.out.println("Press any key to continue...");
			stringScanner.nextLine();
		} else {
			printManage.getPrintPerson().printPersonList(myCompany.getEmployees());
			System.out.print("Please choose employee: ");
			choice = intScanner.nextInt() - 1;
			subMenuEmployee(choice, myCompany);
		}
	}

	public void editAndViewBusinessAssociation(int choice, MyCompany myCompany) {

		if (myCompany.getBusinessAssociates() == null) {
			System.out.println("You dont have any business associets yet");
			System.out.println("Press any key to continue...");
			stringScanner.nextLine();
		} else {
			printManage.getPrintPerson().printPersonList(myCompany.getBusinessAssociates());
			System.out.print("Please choose business associate: ");
			choice = intScanner.nextInt() - 1;
			subMenuBusinessAssociate(choice, myCompany);
		}
		// TODO magic
	}

	public void editAndViewMeeting(MyCompany myCompany) {
		if (myCompany.getMeetings() == null) {
			System.out.println("You dont have any meetings yet");
			System.out.println("Press any key to continue...");
			stringScanner.nextLine();
		} else {
			printManage.getPrintMeeting().printMeetingList(myCompany.getMeetings());
		}
	}

	public void removeEmployee(MyCompany myCompany) {
		if (myCompany.getEmployees() == null) {
			System.out.println("You dont have any employees yet");
			System.out.println("Press any key to continue...");
			stringScanner.nextLine();
		} else {
			System.out.println("Employee removed");
		}
	}

	public void removeBusinessAssociate(MyCompany myCompany) {
		if (myCompany.getBusinessAssociates() == null) {
			System.out.println("You dont have any business associates yet");
			System.out.println("Press any key to continue...");
			stringScanner.nextLine();
		} else {
			System.out.println("Business associate removed");
		}
	}

	public int removeOrView(int input) {
		boolean wrongChoice = false;
		do {
			System.out.println("1. Remove");
			System.out.println("2. Edit and View");
			System.out.print("Choose option: ");
			input = menu.getInput(intScanner);
			if (input != 1 && input != 2) {
				System.out.println("Wrong choice. Try again.");
				wrongChoice = true;
			}
		} while (wrongChoice);

		return input;
	}

	public void addOrViewFamily(Associate currentPerson) {
		boolean failedInput = true;

		if (currentPerson.getFamily() == null) {
			FamilyMembers family = new FamilyMembers();
		}
		do {
			System.out.println("1. Add companion");
			System.out.println("2. Add child");
			System.out.println("3. Edit and View");
			System.out.print("Choose option: ");
			int input = intScanner.nextInt();

			if (input == 1) {
				System.out.print("Enter name: ");
				String name = stringScanner.nextLine();
				LocalDate birthDate = objectManage.getPersonManage().setBirthDate();

				Person companion = new Person(1, name, birthDate);

				currentPerson.getFamily().setCompanion(companion);

				failedInput = false;
			} else if (input == 2) {
				System.out.print("Enter name: ");
				String name = stringScanner.nextLine();
				LocalDate birthDate = objectManage.getPersonManage().setBirthDate();

				if (currentPerson.getFamily().getChildren() == null) {
					currentPerson.getFamily().createChildrenArray();
				}

				Person child = new Person(2, name, birthDate);
				currentPerson.getFamily().addChild(child);

				failedInput = false;
			} else if (input == 3) {

				failedInput = false;
			} else {

				System.out.println("Wrong input, try again.");

			}
		} while (failedInput);
	}
}