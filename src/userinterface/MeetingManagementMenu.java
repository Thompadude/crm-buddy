package userinterface;

import companies.Meeting;
import companies.MyCompany;
import managers.ObjectManage;
import managers.PrintManage;

import java.util.ArrayList;
import java.util.Scanner;

public class MeetingManagementMenu {

    private PrintManage printManage = new PrintManage();
    private ObjectManage objectManage = new ObjectManage();
    private Scanner stringScanner = new Scanner(System.in);
    private Scanner intScanner = new Scanner(System.in);
    private Menu subMenu = new ConsoleMenu();
    private ArrayList<String> meetingManagementMenuAlternatives;
    private int userInputSubMenuChoice;

    protected void meetingManagementMenu(int userInputMenuChoice, MyCompany myCompany) {

        meetingManagementMenuAlternatives = new ArrayList<>();
        meetingManagementMenuAlternatives.add("Edit meeting");
        meetingManagementMenuAlternatives.add("Search protocol key word");
        meetingManagementMenuAlternatives.add("Remove meeting");
        meetingManagementMenuAlternatives.add("Back to main menu");

        do {
            subMenu.setMenuTitle("--- Edit and View Meetings ---");
            subMenu.printMenu(meetingManagementMenuAlternatives);

            System.out.print("\nChoose option: ");
            userInputSubMenuChoice = objectManage.getErrorManage().catchUserInputMismatchException(intScanner);
            System.out.println();

            meetingManagementSwitch(myCompany, userInputMenuChoice, userInputSubMenuChoice);
            if (userInputSubMenuChoice == meetingManagementMenuAlternatives.size() - 1) {
                userInputSubMenuChoice++;
            }
        } while (userInputSubMenuChoice != meetingManagementMenuAlternatives.size());
    }

    private void meetingManagementSwitch(MyCompany myCompany, int userInputMeetingChoice, int userInputSubMenuChoice) {
        switch (userInputSubMenuChoice) {
            case 1:
                objectManage.getMeetingManage().editAndViewMeeting(myCompany, objectManage, intScanner, stringScanner);
                break;
            case 2:
                ArrayList<Meeting> meetingsContainingSearchedWord = objectManage.getSearchManage().searchProtocol(myCompany, stringScanner);
                printManage.getPrintMeeting().printMeetingList(meetingsContainingSearchedWord);

                if (meetingsContainingSearchedWord.size() == 0) {
                    break;
                }

                do {
                    System.out.print("\nChoose meeting: ");
                    userInputMeetingChoice = objectManage.getErrorManage().catchUserInputMismatchException(intScanner);

                    if (!objectManage.getErrorManage().catchArrayIndexOutOfBoundsException(meetingsContainingSearchedWord, userInputMeetingChoice - 1)) {

                        printManage.getPrintMeeting().printInfo(meetingsContainingSearchedWord.get(userInputMeetingChoice - 1));
                        System.out.println();
                        break;
                    }
                } while (true);

                break;
            case 3:
                objectManage.getMeetingManage().completelyDeleteMeeting(myCompany, objectManage, userInputMeetingChoice, stringScanner, intScanner);
            case 4:
                // This option takes you back to the main menu. Leave blank.
                break;
            default:
                System.out.println("Wrong choice! Please try again!");
                break;
        }
    }

}