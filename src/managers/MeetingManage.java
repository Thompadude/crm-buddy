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

        System.out.print("Enter the topic of the meeting: ");
        String topic = stringScanner.nextLine();

        System.out.println("Employees");
        printManage.getPrintPerson().printPersonList(myCompany.getEmployees());
        addParticipant(myCompany, intScanner, tempParticipants, myCompany.getEmployees());

        if (!objManage.getErrorManage().catchArrayListNullPointerException(myCompany.getBusinessAssociates())) {
            System.out.println("Business associates");
            printManage.getPrintPerson().printPersonList(myCompany.getBusinessAssociates());
            addParticipant(myCompany, intScanner, tempParticipants, myCompany.getBusinessAssociates());
        } else {
            System.out.println("NOTE: No business associates available for this meeting.");
        }

        // Prompt user to input a start date of the meeting.
        System.out.println("Set the desired start time: ");
        LocalDateTime startDate = objManage.getDateManage().getPlannedMeetingTimeFromUserInput();
        System.out.println(startDate.toString());

        // Prompt user to input an end date of the meeting.
        // Restart if user tries to put in an end date before a start date.
        System.out.println("Set the desired end time: ");
        LocalDateTime endDate = objManage.getDateManage().getPlannedMeetingTimeFromUserInput();
        if (endDate.isBefore(startDate)) {
            System.out.println("The meeting ends before it begins. Enter correct date.");
            endDate = objManage.getDateManage().getPlannedMeetingTimeFromUserInput();
        }

        // TODO Detta är eventuellt fulkod. Det verkar fungera men ser inte klokt ut.
        Meeting tempMeeting = new Meeting(topic, tempParticipants, startDate, endDate);

        for (int i = 0; i < tempParticipants.size(); i++) {
            if (tempParticipants.get(i).getMeetings() == null) {
                tempParticipants.get(i).setMeetings(new ArrayList<>());
            }
            tempParticipants.get(i).addMeeting(tempMeeting);
        }
        return tempMeeting;
    }

    protected void addParticipant(MyCompany myCompany, Scanner intScanner, ArrayList<Associate> tempParticipants, ArrayList<Associate> currentArrayList) {
        int input;
        boolean exitInput;
        do {
            System.out.print("Add person (press 0 for exit): ");
            input = intScanner.nextInt() - 1;
            if (input < myCompany.getEmployees().size()) {
                tempParticipants.add(currentArrayList.get(input));
            } else {
                System.out.println("Person does not exists!");
            }
            System.out.print("Do you want to add another person? [1]yes/[2]no: ");
            input = intScanner.nextInt();
            if (input == 1) {
                exitInput = false;
            } else {
                exitInput = true;
            }
        } while (!exitInput);
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