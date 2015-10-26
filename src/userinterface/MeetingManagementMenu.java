package userinterface;

import companies.Meeting;
import companies.MyCompany;
import managers.ObjectManage;
import managers.PrintManage;

import java.util.ArrayList;
import java.util.Scanner;

public class MeetingManagementMenu {

    PrintManage printManage = new PrintManage();
    ObjectManage objectManage = new ObjectManage();
    Scanner stringScanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);
    Menu subMenu = new ConsoleMenu();
    ArrayList<String> meetingManagementMenuAlternatives;
    int userInputSubMenuChoice;

    public void meetingManagementMenu(int userInputMenuChoice, MyCompany myCompany) {

        meetingManagementMenuAlternatives = new ArrayList<>();
        meetingManagementMenuAlternatives.add("Edit meeting");
        meetingManagementMenuAlternatives.add("Search protocol key word");
        meetingManagementMenuAlternatives.add("Remove meeting");
        meetingManagementMenuAlternatives.add("Back to main menu");

        do {
            subMenu.setMenuTitle("---Edit and View---");
            subMenu.printMenu(meetingManagementMenuAlternatives);
            System.out.print("Choose option: ");
            userInputSubMenuChoice = subMenu.getInput(intScanner);
            meetingManagementSwitch(myCompany, userInputMenuChoice, userInputSubMenuChoice);
            if (userInputSubMenuChoice == meetingManagementMenuAlternatives.size() - 1) {
                userInputSubMenuChoice++;
            }
        } while (userInputSubMenuChoice != meetingManagementMenuAlternatives.size());
    }

    public void meetingManagementSwitch(MyCompany myCompany, int userInputMeetingChoice, int userInputSubMenuChoice) {
        switch (userInputSubMenuChoice) {
            case 1:
                objectManage.getMeetingManage().editAndViewMeeting(myCompany, objectManage, intScanner, stringScanner);
                break;
            case 2:
                ArrayList<Meeting> meetingsContainingSearchedWord = objectManage.getSearchManage().searchProtocol(myCompany, stringScanner);
                printManage.getPrintMeeting().printMeetingList(meetingsContainingSearchedWord);
                if(meetingsContainingSearchedWord.size() == 0){

                    break;
                }
                do {
                    System.out.print("Choose meeting: ");
                    userInputMeetingChoice = objectManage.getErrorManage().catchUserInputMismatchException(intScanner);

                    if (!objectManage.getErrorManage().catchArrayIndexOutOfBoundsException(meetingsContainingSearchedWord, userInputMeetingChoice - 1)) {

                        printManage.getPrintMeeting().printInfo(meetingsContainingSearchedWord.get(userInputMeetingChoice - 1));
                        break;
                    }
                } while (true);
                break;
            case 3:
                // Completely removes a meeting from program.
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
