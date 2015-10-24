package userinterface;

import companies.Meeting;
import companies.MyCompany;
import entry.TestKlassREMOVE;
import managers.ObjectManage;
import managers.PrintManage;
import persons.Associate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    Scanner stringScanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);
    ObjectManage objectManage = new ObjectManage();
    PrintManage printManage = new PrintManage();
    Menu menu = new ConsoleMenu();
    Menu subMenu = new ConsoleMenu();
    ArrayList<String> mainMenuAlternatives;
    ArrayList<String> personManagementMenuAlternatives;

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
                userInputPersonChoice = promptUserToChoosePerson(myCompany.getEmployees());
                personManagementMenu(userInputPersonChoice, myCompany, myCompany.getEmployees());
                break;
            case 5:
                menuOpen = false;

                if (objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getBusinessAssociates())) {
                    System.out.println("You dont have any business associets yet");
                    System.out.println("Press any key to continue...");
                    stringScanner.nextLine();
                    break;
                }
                userInputPersonChoice = promptUserToChoosePerson(myCompany.getBusinessAssociates());
                personManagementMenu(userInputPersonChoice, myCompany, myCompany.getBusinessAssociates());
                break;
            case 6:
                if (objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getMeetings())) {
                    System.out.println("You dont have any meetings yet");
                    System.out.println("Press any key to continue...");
                    stringScanner.nextLine();
                    break;
                }
//                userInputSubMenuChoice = removeOrView();
//                if (userInputSubMenuChoice == 1) {
//                    // TODO här skall ett möte tas bort
//                    System.out.println("Här ska vi koda hur ett möte tas bort");
//                    break;
//                }
//                if (userInputSubMenuChoice == 2) {
//                    objectManage.getMeetingManage().editAndViewMeeting(myCompany, intScanner, stringScanner);
//                    break;
//                }
//                if (userInputSubMenuChoice == 3) {
//                    // this option takes you back to the main menu. Leave blank.
//                    break;
//                }
                break;
            case 7:
                System.out.println("Saving and logging off");
                break;
            default:
                System.out.println("Wrong choice! Please try again!");
                break;
        }
    }

    public void personManagementMenu(int userInputPersonChoice, MyCompany myCompany, ArrayList<Associate> associate) {

        personManagementMenuAlternatives = new ArrayList<>();
        personManagementMenuAlternatives.add("Edit name");
        personManagementMenuAlternatives.add("Edit birthdate");
        personManagementMenuAlternatives.add("Edit address");
        personManagementMenuAlternatives.add("Edit e-mail");
        personManagementMenuAlternatives.add("Edit phone number");
        personManagementMenuAlternatives.add("Edit position");
        personManagementMenuAlternatives.add("Create family member");
        personManagementMenuAlternatives.add("Remove this person");
        personManagementMenuAlternatives.add("Back to main menu");

        do {
            printManage.getPrintPerson().printInfo(associate.get(userInputPersonChoice));
            subMenu.setMenuTitle("---Edit and View---");
            subMenu.printMenu(personManagementMenuAlternatives);
            System.out.print("Choose option: ");
            userInputSubMenuChoice = menu.getInput(intScanner);
            personManagementSwitch(myCompany, userInputPersonChoice, userInputSubMenuChoice, associate);
        } while (userInputSubMenuChoice != personManagementMenuAlternatives.size());

    }

    public void personManagementSwitch(MyCompany myCompany, int userInputPersonChoice, int userInputSubMenuChoice, ArrayList<Associate> associate) {
        switch (userInputSubMenuChoice) {
            case 1:
                System.out.print("Set new name: ");
                String name = stringScanner.nextLine();
                associate.get(userInputPersonChoice).setName(name);
                break;
            case 2:
                LocalDate birthDate = objectManage.getDateManage().getBirthDateFromUserInput();
                associate.get(userInputPersonChoice).setBirthDate(birthDate);
                break;
            case 3:
                System.out.print("Set new address: ");
                String address = stringScanner.nextLine();
                associate.get(userInputPersonChoice).getContactInfo().setAddress(address);
                break;
            case 4:
                System.out.print("Set new email: ");
                String email = stringScanner.nextLine();
                email = objectManage.getContactInfoManage().setEmail(email, stringScanner);
                associate.get(userInputPersonChoice).getContactInfo().setEmail(email);
                break;
            case 5:
                System.out.print("Set new phone number: ");
                String phoneNumber = stringScanner.nextLine();
                associate.get(userInputPersonChoice).getContactInfo().setPhoneNumber(phoneNumber);
                break;
            case 6:
                System.out.println("Edit position");
                String position = stringScanner.nextLine();
                associate.get(userInputPersonChoice).setPosition(position);
                break;
            case 7:
                if (objectManage.getErrorManage().catchArrayListNullPointerException(associate.get(userInputPersonChoice).getFamilyMembers())) {
                    associate.get(userInputPersonChoice).setFamilyMembers(new ArrayList<>());
                }
                associate.get(userInputPersonChoice).getFamilyMembers().add(objectManage.getPersonManage().createFamilyMember(stringScanner));
                break;
            case 8:
                objectManage.getPersonManage().removePerson(myCompany, userInputPersonChoice, associate, intScanner);
                System.out.println("Press any key to continue...");
                stringScanner.nextLine();
                mainMenu(myCompany);
                break;
            case 9:
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

}