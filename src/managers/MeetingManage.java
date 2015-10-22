package managers;

import companies.Journal;
import companies.Meeting;
import companies.MyCompany;
import persons.Associate;

import java.util.ArrayList;
import java.util.Scanner;

public class MeetingManage {

    PrintManage printManage = new PrintManage();

    //ArrayList<Associate> participants is stored in UI
    public Meeting createMeeting(MyCompany myCompany, ObjectManage objManage, Scanner stringScanner, Scanner intScanner) {
        System.out.print("Please enter the topic of the meeting: ");
        String topic = stringScanner.nextLine();

        printManage.getPrintPerson().printPersonList(myCompany.getEmployees());

        ArrayList<Associate> tempParticipants = new ArrayList<Associate>();
        addParticipant(myCompany, intScanner, tempParticipants);

        printManage.getPrintPerson().printPersonList(myCompany.getBusinessAssociates());

        return new Meeting(topic, participants, startDate, endDate);
    }

    public void addParticipant(MyCompany myCompany, Scanner intScanner, ArrayList<Associate> tempParticipants) {
        int input;
        do {
            System.out.print("Please add employee (press 0 for exit): ");
            input = intScanner.nextInt();
            input--;
            if (input < myCompany.getEmployees().size()) {
                tempParticipants.add(myCompany.getEmployees().get(input));
            } else {
                System.out.println("Employee does not exists!");
            }
        } while (input != 0);
    }

    public void removeParticipant(Meeting meeting, String searchName) {
        for (int i = 0; i < meeting.getParticipants().size(); i++) {
            if (searchName.toLowerCase().equals(meeting.getParticipants().get(i).getName().toLowerCase())) {
                meeting.getParticipants().remove(i);
            }
        }
    }

    //TODO if-statements for journal rules
    public void createJournal(Meeting meeting, ArrayList<String> protocol) {
        meeting.setJournal(new Journal(protocol));
    }
}