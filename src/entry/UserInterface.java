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

    int userInputMenuChoice;
    int userInputPersonChoice;
    int userInputSubMenuChoice;
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
            userInputMenuChoice = menu.getInput(intScanner);
            mainMenuSwitch(userInputMenuChoice, myCompany);
        } while (userInputMenuChoice != mainMenuAlternatives.size());
    }

    public void mainMenuSwitch(int userInputMenuChoice, MyCompany myCompany) {

        switch (userInputMenuChoice) {
            case 1:
                myCompany
                        .addEmployee(objectManage.getPersonManage().createEmployee(myCompany, objectManage, stringScanner));
                break;
            case 2:
                myCompany.addBusinessAssociate(objectManage.getPersonManage().createBusinessAssociate(myCompany,
                        objectManage, stringScanner, intScanner));
                break;
            case 3:
                // TODO
                // Det ska inte vara möjligt att skapa ett möte om man har minst en
                // employee,
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
                    userInputSubMenuChoice = removeOrView();

                    switch (userInputSubMenuChoice) {
                        case 1:
                            userInputPersonChoice = promptUserToChoosePerson(myCompany.getEmployees());
                            removePerson(myCompany, userInputPersonChoice, myCompany.getEmployees());
                            menuOpen = false;
                            break;
                        case 2:
                            userInputPersonChoice = promptUserToChoosePerson(myCompany.getEmployees());
                            editAndViewPersonMenu(userInputPersonChoice, myCompany, myCompany.getEmployees());
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
                    userInputSubMenuChoice = removeOrView();

                    switch (userInputSubMenuChoice) {
                        case 1:
                            userInputPersonChoice = promptUserToChoosePerson(myCompany.getBusinessAssociates());
                            removePerson(myCompany, userInputPersonChoice, myCompany.getBusinessAssociates());
                            menuOpen = false;
                            break;
                        case 2:
                            userInputPersonChoice = promptUserToChoosePerson(myCompany.getBusinessAssociates());
                            editAndViewPersonMenu(userInputPersonChoice, myCompany, myCompany.getBusinessAssociates());
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
                userInputSubMenuChoice = removeOrView();
                if (userInputSubMenuChoice == 1) {
                    // TODO här skall ett möte tas bort
                    System.out.println("Här ska vi koda hur ett möte tas bort");
                    break;
                }
                if (userInputSubMenuChoice == 2) {
                    objectManage.getMeetingManage().editAndViewMeeting(myCompany, intScanner, stringScanner);
                    break;
                }
                if (userInputSubMenuChoice == 3) {
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

    public void editAndViewPersonMenu(int userInputPersonChoice, MyCompany myCompany, ArrayList<Associate> persons) {
        Associate currentPerson = persons.get(userInputPersonChoice);

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
            userInputSubMenuChoice = menu.getInput(intScanner);
            editAndViewPersonSwitch(userInputSubMenuChoice, currentPerson);
        } while (userInputSubMenuChoice != editAndViewPersonMenuAlternatives.size());

    }

    public void editAndViewPersonSwitch(int userInputSubMenuChoice, Associate currentPerson) {

        switch (userInputSubMenuChoice) {
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

    public int promptUserToChoosePerson(ArrayList<Associate> persons) {
        printManage.getPrintPerson().printPersonList(persons);
        System.out.print("Choose person: ");
        return menu.getInput(intScanner) - 1;
    }

    public void removePerson(MyCompany myCompany, int userInputPersonChoice, ArrayList<Associate> person) {
        if (objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getPastContacts())) {
            myCompany.createPastContacts();
        }
        System.out.println(person.get(userInputPersonChoice).getName() + " removed!");
        myCompany.addPastContact(person.get(userInputPersonChoice));
        person.remove(userInputPersonChoice);

    }

    public int removeOrView() {
        System.out.println("1. Remove");
        System.out.println("2. Edit and View");
        System.out.println("3. Go Back");
        System.out.print("Choose option: ");
        userInputMenuChoice = menu.getInput(intScanner);
        return userInputMenuChoice;
    }

}