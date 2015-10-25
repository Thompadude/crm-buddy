package userinterface;

import companies.Meeting;
import companies.MyCompany;
import entry.TestKlassREMOVE;
import managers.ObjectManage;
import managers.PrintManage;
import persons.Associate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainMenu {

    Scanner stringScanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);
    ObjectManage objectManage = new ObjectManage();
    PrintManage printManage = new PrintManage();
    Menu menu = new ConsoleMenu();
    PersonManagementMenu personManagementMenu = new PersonManagementMenu();
    ArrayList<String> mainMenuAlternatives;

    int userInputMenuChoice;
    int userInputPersonChoice;
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
            mainMenuAlternatives = new ArrayList<>();
            mainMenuAlternatives.add("Create employee");
            mainMenuAlternatives.add("Create business contact");
            mainMenuAlternatives.add("Create meeting");
            mainMenuAlternatives.add("Manage employee");
            mainMenuAlternatives.add("Manage business contact");
            mainMenuAlternatives.add("Manage meeting");
            mainMenuAlternatives.add("Save & Quit system");

            menu.printMenu(mainMenuAlternatives);

            ArrayList<Associate> allAssociates = new ArrayList<>();
            if(!objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getEmployees())) {
                allAssociates.addAll(myCompany.getEmployees());
            }
            if (!objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getBusinessAssociates())) {
                allAssociates.addAll(myCompany.getBusinessAssociates());

            }
            if(!objectManage.getErrorManage().catchArrayListNullPointerException(allAssociates)) {
                printManage.getPrintPerson().printBirthDateAllPersons(allAssociates);
            }

            System.out.print("Choose option: ");
            userInputMenuChoice = menu.getInput(intScanner);
            mainMenuSwitch(userInputMenuChoice, myCompany);
        } while (userInputMenuChoice != mainMenuAlternatives.size());
    }

    public void mainMenuSwitch(int userInputMenuChoice, MyCompany myCompany) {

        switch (userInputMenuChoice) {
            case 1:
                myCompany.addEmployee(objectManage.getPersonManage().createEmployee(myCompany, objectManage, stringScanner));
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
                    System.out.println("You don't have any employees yet.");
                    System.out.println("Press any key to continue...");
                    stringScanner.nextLine();
                    break;
                }
                Meeting tempMeeting = objectManage.getMeetingManage().createMeeting(myCompany, objectManage, stringScanner, intScanner);
                if (objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getMeetings())) {
                    myCompany.createMeetings();
                }

                myCompany.getMeetings().add(tempMeeting);
                break;
            case 4:
                menuOpen = false;

                if (objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getEmployees())) {
                    System.out.println("You don't have any employees yet");
                    System.out.println("Press any key to continue...");
                    stringScanner.nextLine();
                    break;
                }
                userInputPersonChoice = promptUserToChoosePerson(myCompany.getEmployees());
                personManagementMenu.personManagementMenu(userInputPersonChoice, myCompany, myCompany.getEmployees());
                break;
            case 5:
                menuOpen = false;

                if (objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getBusinessAssociates())) {
                    System.out.println("You don't have any business associates yet");
                    System.out.println("Press any key to continue...");
                    stringScanner.nextLine();
                    break;
                }
                userInputPersonChoice = promptUserToChoosePerson(myCompany.getBusinessAssociates());
                personManagementMenu.personManagementMenu(userInputPersonChoice, myCompany, myCompany.getBusinessAssociates());
                break;
            case 6:
                if (objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getMeetings())) {
                    System.out.println("You don't have any meetings yet");
                    System.out.println("Press any key to continue...");
                    stringScanner.nextLine();
                    break;
                }
                objectManage.getMeetingManage().editAndViewMeeting(myCompany, objectManage, intScanner, stringScanner);
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

    public int promptUserToChoosePerson(ArrayList<Associate> persons) {
        printManage.getPrintPerson().printPersonList(persons);
        System.out.print("Choose person: ");
        return menu.getInput(intScanner) - 1;
    }

}