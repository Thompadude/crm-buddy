package entry;

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
                myCompany.addEmployee(objectManage.getPersonManage().createEmployee(myCompany, objectManage, stringScanner));
                break;
            case 2:
                myCompany.addBusinessAssociate(objectManage.getPersonManage().createBusinessAssociate(myCompany, objectManage, stringScanner, intScanner));
                break;
            case 3:
                // TODO
                // Det ska inte vara möjligt att skapa ett möte om man har minst en employee,
                // men INTE business associate?
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
                    // TODO här skall ett möte tas bort
                    System.out.println("Här ska vi koda hur ett möte tas bort");
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
                LocalDate birthDate = objectManage.getDateManage().getBirthDateFromUserInput();
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
        userInput = menu.getInput(intScanner);
        return userInput;
    }

}