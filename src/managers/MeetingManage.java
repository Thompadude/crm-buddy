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
        Meeting tempMeeting = null;
        while (tempMeeting == null) {
            if (endDate.isBefore(startDate)) {
                System.out.println("The meeting ends before it begins. Enter correct date.");
                endDate = objManage.getDateManage().getPlannedMeetingTimeFromUserInput();
            } else {
                tempMeeting = new Meeting(topic, tempParticipants, startDate, endDate);
            }
        }
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

    /**
     * Completely removes a meeting from the program. Before removing the meeting from myCompany,
     * search all persons to check if the meeting exists in them, and then delete it.
     */
    public void completelyDeleteMeeting(MyCompany myCompany, ObjectManage objectManage, int userInputMeetingChoice, Scanner stringScanner, Scanner intScanner) {
        printManage.getPrintMeeting().printMeetingList(myCompany.getMeetings());
        do {
            System.out.print("\nChoose meeting: ");
            userInputMeetingChoice = objectManage.getErrorManage().catchUserInputMismatchException(intScanner) - 1;
            if (!objectManage.getErrorManage().catchArrayIndexOutOfBoundsException(myCompany.getMeetings(), userInputMeetingChoice)) {
                System.out.println("The meeting with topic: " + myCompany.getMeetings().get(userInputMeetingChoice).getTopic()
                        + " removed!");
                if (!objectManage.getErrorManage().catchArrayListNullPointerException(myCompany.getBusinessAssociates())) {
                    for (int i = 0; i < myCompany.getBusinessAssociates().size(); i++) {
                        if (!(myCompany.getBusinessAssociates().get(i).getMeetings() == null)) {

                            for (int j = 0; j < myCompany.getBusinessAssociates().get(i).getMeetings().size(); j++) {
                                if (myCompany.getBusinessAssociates().get(i).getMeetings().get(j) == myCompany.getMeetings().get(userInputMeetingChoice)) {
                                    myCompany.getBusinessAssociates().get(i).getMeetings().remove(j);
                                    break;
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < myCompany.getEmployees().size(); i++) {
                    if (!(myCompany.getEmployees().get(i).getMeetings() == null)) {
                        for (int j = 0; j < myCompany.getEmployees().get(i).getMeetings().size(); j++) {
                            if (myCompany.getEmployees().get(i).getMeetings().get(j) == myCompany.getMeetings().get(userInputMeetingChoice)) {
                                myCompany.getEmployees().get(i).getMeetings().remove(j);
                                break;
                            }
                        }
                    }
                }
                myCompany.getMeetings().remove(userInputMeetingChoice);
                System.out.print("Press any key to continue...");
                stringScanner.nextLine();
                System.out.println();
                break;
            }
        } while (true);
    }

    /**
     * Takes an array list of strings and create a protocol to put in Journal.
     */
    public ArrayList<String> createProtocol(ObjectManage objectManage, Scanner stringScanner, Scanner intScanner) {
        ArrayList<String> items = new ArrayList<String>();
        int itemCounter = 1;
        boolean addMore = true;
        do {
            System.out.print("Type item number " + itemCounter + ": ");
            items.add(stringScanner.nextLine());
            boolean wrongInput = false;
            do {
                System.out.print("Do you want to type another item? [1]Yes/[2]No: ");
                ConsoleMenu consoleMenu = new ConsoleMenu();
                int choice = objectManage.getErrorManage().catchUserInputMismatchException(intScanner);
                System.out.println();
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
        return items;
    }

    public void editAndViewMeeting(MyCompany myCompany, ObjectManage objectManage, Scanner intScanner, Scanner stringScanner) {
        boolean wrongChoice;
        int userInputMeetingChoice;
        printManage.getPrintMeeting().printMeetingList(myCompany.getMeetings());
        System.out.print("\nChoose meeting: ");
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
            System.out.print("\nDo you want to create a journal? [1]Yes/[2]No: ");
            int userInputCreateJournalPrompt = objectManage.getErrorManage().catchUserInputMismatchException(intScanner);
            System.out.println();
            switch (userInputCreateJournalPrompt) {
                case 1:
                    if (myCompany.getMeetings().get(userInputMeetingChoice).getJournal() == null) {
                        ArrayList<String> protocol = objectManage.getMeetingManage().createProtocol(objectManage, stringScanner, intScanner);
                        Journal tempJournal = new Journal(protocol);
                        myCompany.getMeetings().get(userInputMeetingChoice).setJournal(tempJournal);
                    } else {
                        System.out.println("Journal is already created. It is permanent. No changes allowed!\n");
                    }
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