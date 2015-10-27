package userinterface;

import companies.Company;
import companies.Meeting;
import companies.MyCompany;
import managers.ObjectManage;
import managers.PrintManage;
import persons.Associate;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    Scanner stringScanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);
    ObjectManage objectManage = new ObjectManage();
    PrintManage printManage = new PrintManage();
    Menu menu = new ConsoleMenu();
    PersonManagementMenu personManagementMenu = new PersonManagementMenu();
    MeetingManagementMenu meetingManagementMenu = new MeetingManagementMenu();
    ArrayList<String> mainMenuAlternatives;

    int userInputMenuChoice;
    int userInputPersonChoice;
    boolean menuOpen;

    String wrongChoice = "Wrong choice. Try again.";

    public void mainMenu(MyCompany myCompany) {

        // Print persons with birthday within 5 days (sorted).
        printManage.getPrintPerson().collectAllPersonsInAListAndSendToPrintBirthDates(myCompany, objectManage);
        // Print meetings planned today.
        printManage.getPrintMeeting().printTodaysMeetings(myCompany.getMeetings(), objectManage);

        do {
            menu.setMenuTitle("--- Main Menu ---");
            mainMenuAlternatives = new ArrayList<>();
            mainMenuAlternatives.add("Create employee");
            mainMenuAlternatives.add("Create business contact");
            mainMenuAlternatives.add("Create meeting");
            mainMenuAlternatives.add("Manage employee");
            mainMenuAlternatives.add("Manage business contact");
            mainMenuAlternatives.add("Manage meeting");
            mainMenuAlternatives.add("List companies");
            mainMenuAlternatives.add("Save & Quit system");

            menu.printMenu(mainMenuAlternatives);

            System.out.print("\nChoose option: ");
            userInputMenuChoice = objectManage.getErrorManage().catchUserInputMismatchException(intScanner);
            System.out.println();

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

                if (objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getEmployees())
                        || myCompany.getEmployees().size() == 0) {
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

                if (objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getBusinessAssociates())
                        || myCompany.getBusinessAssociates().size() == 0) {
                    System.out.println("You don't have any business associates yet");
                    System.out.println("Press any key to continue...");
                    stringScanner.nextLine();
                    break;
                }

                userInputPersonChoice = promptUserToChoosePerson(myCompany.getBusinessAssociates());
                personManagementMenu.personManagementMenu(userInputPersonChoice, myCompany, myCompany.getBusinessAssociates());
                break;
            case 6:
                if (objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getMeetings())
                        || myCompany.getMeetings().size() == 0) {
                    System.out.println("You don't have any meetings yet");
                    System.out.println("Press any key to continue...");
                    stringScanner.nextLine();
                    break;
                }

                meetingManagementMenu.meetingManagementMenu(userInputMenuChoice, myCompany);
                break;
            case 7:
                printManage.getPrintCompany().printInfo(myCompany);

                if (!objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getAssociatedCompanies())) {
                    do {
                        System.out.print("\n--- Managed companies ---");
                        printManage.getPrintCompany().printListOfAllCompanies(myCompany);


                        System.out.print("\nChoose company: ");
                        userInputMenuChoice = objectManage.getErrorManage().catchUserInputMismatchException(intScanner) - 1;
                        System.out.println();
                    }
                    while (objectManage.getErrorManage().catchArrayIndexOutOfBoundsException(myCompany.getAssociatedCompanies(), userInputMenuChoice));

                    printManage.getPrintCompany().printInfo(myCompany.getAssociatedCompanies().get(userInputMenuChoice));
                    System.out.println("--- Added associates ---");
                    for (int i = 0; i < myCompany.getBusinessAssociates().size(); i++) {
                        if (myCompany.getAssociatedCompanies().get(userInputMenuChoice).getName().equals(myCompany.getBusinessAssociates().get(i).getCompany().getName())) {
                            System.out.println("* " + myCompany.getBusinessAssociates().get(i).getName());
                        }
                    }
                    System.out.println("\nPress any key to continue...");
                    stringScanner.nextLine();
                } else {
                    System.out.println("\nYou don't have any business companies yet!");
                    System.out.println("Press any key to continue...");
                    stringScanner.nextLine();
                }
                break;
            case 8:
                System.out.println("Saving and logging off");
                break;
            default:
                System.out.println(wrongChoice);
                break;
        }

    }

    public int promptUserToChoosePerson(ArrayList<Associate> persons) {
        printManage.getPrintPerson().printPersonList(persons);

        do {
            System.out.print("\nChoose person: ");
            userInputPersonChoice = objectManage.getErrorManage().catchUserInputMismatchException(intScanner) - 1;
            menuOpen = objectManage.getErrorManage().catchArrayIndexOutOfBoundsException(persons, userInputPersonChoice);
        } while (menuOpen);

        return userInputPersonChoice;
    }

}