package entry;

import companies.Journal;
import companies.Meeting;
import companies.MyCompany;
import managers.ObjectManage;
import managers.PrintManage;
import menysystem.ConsoleMenu;
import menysystem.Menu;
import persons.Associate;

import java.time.LocalDate;
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
    ArrayList<String> editAndViewPersonMenuAlternatives;

    int userInput;
    boolean menuOpen;

    public void mainMenu(MyCompany myCompany) {

        // TODO RADERA DENNA KOD INNAN INL�MNING! V�RA TESTPERSONER LIGGER I
        // TESTKLASSEN! RADERA �VEN KLASS!(RADERA FR�N MAPP �X�)
        TestKlassREMOVE testklassRemove = new TestKlassREMOVE();
        testklassRemove.TestKlass(myCompany);
        // TODO SLUT P� RADERING

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

            menu.printMenu(mainMenuAlternatives);
            System.out.print("Choose option: ");
            userInput = menu.getInput(intScanner);
            mainMenuSwitch(userInput, myCompany);
        } while (userInput != mainMenuAlternatives.size());
    }

    public void mainMenuSwitch(int input, MyCompany myCompany) {
        int choice;

        switch (input) {
            case 1:
                Associate tempEmployee = objectManage.getPersonManage().createEmployee(myCompany, objectManage, stringScanner);
                myCompany.addEmployee(tempEmployee);
                break;
            case 2:
                Associate tempBusinessAssociate = objectManage.getPersonManage().createBusinessAssociate(myCompany, objectManage, stringScanner, intScanner);
                myCompany.addBusinessAssociate(tempBusinessAssociate);
                break;
            case 3:
                // TODO
                // Ska det vara m�jligt att skapa ett m�te om man INTE har en
                // employee?
                // Ska det vara m�jligt att skapa ett m�te OM man har en employee,
                // men INTE business associate?
                // Is�fall m�ste vi �ndra regler i create meeting
                // TODO SLUT
                if (objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getEmployees())) {
                    System.out.println("You dont have any employees yet.");
                    System.out.println("Press any key to continue...");
                    stringScanner.nextLine();
                    break;
                }
                Meeting tempMeeting = objectManage.getMeetingManage().createMeeting(myCompany, objectManage, stringScanner,
                        intScanner);
                if (objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getMeetings())) {
                    myCompany.createMeetings();
                }

                myCompany.getMeetings().add(tempMeeting);
                break;
            case 4:
                menuOpen = false;

                if (objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getEmployees())) {
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
                            menuOpen = false;
                            break;
                        case 2:
                            promptUserToChoosePerson(myCompany, input, myCompany.getEmployees());
                            menuOpen = false;
                            break;
                        case 3:
                            // this option takes you back to the main menu. Leave blank.
                            menuOpen = false;
                            break;
                        default:
                            System.out.println("Wrong choice! Try again!");
                            menuOpen = true;
                            break;
                    }
                } while (menuOpen);
                break;
            case 5:
                menuOpen = false;

                if (objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getBusinessAssociates())) {
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
                            menuOpen = false;
                            break;
                        case 2:
                            promptUserToChoosePerson(myCompany, input, myCompany.getBusinessAssociates());
                            menuOpen = false;
                            break;
                        case 3:
                            // this option takes you back to the main menu. Leave blank.
                            menuOpen = false;
                            break;
                        default:
                            System.out.println("Wrong choice! Try again!");
                            menuOpen = true;
                            break;
                    }
                } while (menuOpen);
                break;
            case 6:
                if (objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getMeetings())) {
                    System.out.println("You dont have any meetings yet");
                    System.out.println("Press any key to continue...");
                    stringScanner.nextLine();
                    break;
                }
                choice = removeOrView();
                if (choice == 1) {
                    // TODO h�r skall ett m�te tas bort
                    System.out.println("H�r ska vi koda hur ett m�te tas bort");
                    break;
                }
                if (choice == 2) {
                    objectManage.getMeetingManage().editAndViewMeeting(myCompany, intScanner, stringScanner);
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

    public void editAndViewPersonMenu(int choice, MyCompany myCompany, ArrayList<Associate> persons) {
        Associate currentPerson = persons.get(choice);

        // SUB MENU ALTERNATIVES
        editAndViewPersonMenuAlternatives = new ArrayList<String>();
        editAndViewPersonMenuAlternatives.add("Edit name");
        editAndViewPersonMenuAlternatives.add("Edit birthdate");
        editAndViewPersonMenuAlternatives.add("Edit address");
        editAndViewPersonMenuAlternatives.add("Edit e-mail");
        editAndViewPersonMenuAlternatives.add("Edit phonenumber");
        editAndViewPersonMenuAlternatives.add("Edit position");
        editAndViewPersonMenuAlternatives.add("Create familymembers");
        editAndViewPersonMenuAlternatives.add("Back to main menu");

        do {
            printManage.getPrintPerson().printInfo(currentPerson);
            subMenu.setMenuTitle("---Edit and View---");
            subMenu.printMenu(editAndViewPersonMenuAlternatives);
            System.out.print("Choose option: ");
            userInput = menu.getInput(intScanner);
            editAndViewPersonSwitch(userInput, myCompany, currentPerson);
        } while (userInput != editAndViewPersonMenuAlternatives.size());

    }

    public void editAndViewPersonSwitch(int input, MyCompany myCompany, Associate currentPerson) {

        switch (input) {
            case 1:
                System.out.print("Set new name: ");
                String name = stringScanner.nextLine();
                currentPerson.setName(name);
                break;
            case 2:
                LocalDate birthDate = objectManage.getPersonManage().getBirthDateFromUserInput();
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
                System.out.println("Edit position");
                String position = stringScanner.nextLine();
                currentPerson.setPosition(position);
                break;
            case 7:
                if (objectManage.getErrorManage().catchArrayListNullPointerException(currentPerson.getFamilyMembers())) {
                    currentPerson.setFamilyMembers(new ArrayList<>());
                }
                currentPerson.getFamilyMembers().add(objectManage.getPersonManage().createFamilyMember(stringScanner));
                break;
            case 8:
                // this option takes you back to the main menu. Leave blank.
                break;
            default:
                System.out.println("Wrong choice! Please try again!");
                break;
        }
    }

    public void promptUserToChoosePerson(MyCompany myCompany, int choice, ArrayList<Associate> persons) {
        printManage.getPrintPerson().printPersonList(persons);
        System.out.print("Choose person: ");
        choice = menu.getInput(intScanner) - 1;
        editAndViewPersonMenu(choice, myCompany, persons);
    }



    public void removeEmployee(MyCompany myCompany) {
        // H�r ska en person sparas i past employees och sen raderas!
        System.out.println("Employee removed");
    }

    public void removeBusinessAssociate(MyCompany myCompany) {
        // H�r ska v�l en Business associate sparas i n�n past array, och sen
        // sl�ngas?
        System.out.println("Business associate removed");
    }

    public int removeOrView() {
        System.out.println("1. Remove");
        System.out.println("2. Edit and View");
        System.out.println("3. Go Back");
        System.out.print("Choose option: ");
        userInput = menu.getInput(intScanner);
        return userInput;
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
	 * objectManage.getPersonManage().getBirthDateFromUserInput();
	 * 
	 * FamilyMember companion = new FamilyMember(1, name, birthDate);
	 * 
	 * currentPerson.getFamilyMembers().add(companion);
	 * 
	 * failedInput = false; } else if (input == 2) { System.out.print(
	 * "Enter name: "); String name = stringScanner.nextLine(); LocalDate
	 * birthDate = objectManage.getPersonManage().getBirthDateFromUserInput();
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