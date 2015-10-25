package managers;

import companies.Journal;
import companies.Meeting;
import companies.MyCompany;
import persons.Associate;
import userinterface.ConsoleMenu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MeetingManage {

    PrintManage printManage = new PrintManage();

    public Meeting createMeeting(MyCompany myCompany, ObjectManage objManage, Scanner stringScanner, Scanner intScanner) {
        ArrayList<Associate> tempParticipants = new ArrayList<>();

        System.out.print("\nEnter the topic of the meeting: ");
        String topic = stringScanner.nextLine();

        System.out.println("\n--- Employees ---");
        printManage.getPrintPerson().printPersonList(myCompany.getEmployees());

        addParticipant(intScanner, tempParticipants, myCompany.getEmployees());

        if (!objManage.getErrorManage().catchArrayListNullPointerException(myCompany.getBusinessAssociates())) {
            System.out.println("\n--- Business associates ---");
            printManage.getPrintPerson().printPersonList(myCompany.getBusinessAssociates());
            addParticipant(intScanner, tempParticipants, myCompany.getBusinessAssociates());
        } else {
            System.out.println("NOTE: No business associates available for this meeting.");
        }

        // Prompt user to input a start date of the meeting.
        System.out.println("\nSet the desired start time: ");
        LocalDateTime startDate = objManage.getDateManage().getPlannedMeetingTimeFromUserInput();

        // Prompt user to input an end date of the meeting.
        // Restart if user tries to put in an end date before a start date.
        System.out.println("\nSet the desired end time: ");
        LocalDateTime endDate = objManage.getDateManage().getPlannedMeetingTimeFromUserInput();
        if (endDate.isBefore(startDate)) {
            System.out.println("The meeting ends before it begins. Enter correct date.");
            endDate = objManage.getDateManage().getPlannedMeetingTimeFromUserInput();
        }

        // TODO Detta är eventuellt fulkod. Det verkar fungera men ser inte klokt ut.
        Meeting tempMeeting = new Meeting(topic, tempParticipants, startDate, endDate);
        printManage.getPrintMeeting().printNewlyCreatedMeeting(tempMeeting, stringScanner);

        for (int i = 0; i < tempParticipants.size(); i++) {
            if (tempParticipants.get(i).getMeetings() == null) {
                tempParticipants.get(i).setMeetings(new ArrayList<>());
            }
            tempParticipants.get(i).addMeeting(tempMeeting);
        }
        return tempMeeting;
    }

    protected void addParticipant(Scanner intScanner, ArrayList<Associate> tempParticipants, ArrayList<Associate> currentArrayList) {
        ObjectManage objectManage = new ObjectManage();
        int input;
        boolean menuOpen;
        boolean goAgain = true;
        boolean addMoreFail;
        while (goAgain) {
            do {
                System.out.print("Add person: ");
                input = objectManage.getErrorManage().catchUserInputMismatchException(intScanner) - 1;
                menuOpen = objectManage.getErrorManage().catchArrayIndexOutOfBoundsException(currentArrayList, input);
            } while (menuOpen);
            tempParticipants.add(currentArrayList.get(input));
            System.out.print("Do you want to add another person? [1]Yes/[2]No: ");

            do {
                input = objectManage.getErrorManage().catchUserInputMismatchException(intScanner);
                if (input == 1) {
                    addMoreFail = false;
                    goAgain = true;
                } else if (input == 2) {
                    addMoreFail = false;
                    goAgain = false;
                } else {
                    System.out.print("Wrong choice. Try again: ");
                    addMoreFail = true;
                    goAgain = false;
                }
            } while (addMoreFail);
        }
    }

    protected void removeParticipant(Meeting meeting, String searchName) {
        for (int i = 0; i < meeting.getParticipants().size(); i++) {
            if (searchName.toLowerCase().equals(meeting.getParticipants().get(i).getName().toLowerCase())) {
                meeting.getParticipants().remove(i);
            }
        }
    }

    public ArrayList<String> createProtocol(Scanner stringScanner, Scanner intScanner) {
        ArrayList<String> protocol = new ArrayList<String>();
        int itemCounter = 1;
        boolean addMore = true;
        do {
            System.out.print("Type item number " + itemCounter + " : ");
            protocol.add(stringScanner.nextLine());
            boolean wrongInput = false;
            do {
                System.out.print("Do you want to type another item? [1]Yes/[2]No: ");
                ConsoleMenu consoleMenu = new ConsoleMenu();
                int choice = consoleMenu.getInput(intScanner);

                if (choice == 1) {
                    itemCounter++;
                    wrongInput = false;
                } else if (choice == 2) {
                    addMore = false;
                    wrongInput = false;
                } else if (choice != 1 || choice != 2) {
                    wrongInput = true;
                    System.out.println("Wrong input. Try again!");
                }
            } while (wrongInput);
        } while (addMore);
        return protocol;
    }

    public void editAndViewMeeting(MyCompany myCompany, ObjectManage objectManage, Scanner intScanner, Scanner stringScanner) {
        boolean wrongChoice;
        int userInputMeetingChoice;
        printManage.getPrintMeeting().printMeetingList(myCompany.getMeetings());
        System.out.print("Choose meeting: ");
        do {
            userInputMeetingChoice = objectManage.getErrorManage().catchUserInputMismatchException(intScanner) - 1;
            if (userInputMeetingChoice < 0 || userInputMeetingChoice > myCompany.getMeetings().size() - 1) {
                System.out.print("Wrong choice! Try again: ");
                wrongChoice = true;
            } else {
                myCompany.getMeetings().get(userInputMeetingChoice);
                wrongChoice = false;
            }
        } while (wrongChoice);
        printManage.getPrintMeeting().printInfo(myCompany.getMeetings().get(userInputMeetingChoice));
        do {
            System.out.print("Do you want to create a journal? [1]Yes/[2]No: ");
            int userInputCreateJournalPrompt = objectManage.getErrorManage().catchUserInputMismatchException(intScanner);
            switch (userInputCreateJournalPrompt) {
                case 1:
                    ArrayList<String> protocol = objectManage.getMeetingManage().createProtocol(stringScanner, intScanner);
                    Journal tempJournal = new Journal(protocol);
                    myCompany.getMeetings().get(userInputMeetingChoice).setJournal(tempJournal);
                    wrongChoice = false;
                    break;
                case 2:
                    // This option takes you back to the main menu. Leave blank.
                    wrongChoice = false;
                    break;
                default:
                    System.out.print("Wrong choice! Try again: ");
                    wrongChoice = true;
                    break;
            }
        } while (wrongChoice);
    }

}