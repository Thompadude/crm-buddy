package printers;

import companies.Meeting;

import java.util.ArrayList;

public class PrintMeeting implements Printable {

    public void printMeetingList(ArrayList<Meeting> meetings) {
        System.out.println("Date\tTopic");
        int counter = 1;
        for (Meeting meeting : meetings) {
            System.out.println(counter + ". " + meeting.getStartDate() +
                    "   " + meeting.getTopic());
            counter++;
        }
    }

    @Override
    public <T> void printInfo(T t) {
        if (t instanceof Meeting) {
            System.out.print("Date: " + ((Meeting) t).getStartDate().toString() + " - " +
                    ((Meeting) t).getEndDate().toString());
            System.out.println("\t " + ((Meeting) t).getTopic());

            System.out.println("Participants: ");
            printParticipants(((Meeting) t));

            System.out.println("Protocol :");
            printProtocol(((Meeting) t));
        }
    }

    public void printParticipants(Meeting meeting) {
        for (int i = 0; i < meeting.getParticipants().size(); i++) {
            if ((i % 3) == 0) {
                System.out.println();
            }
            System.out.print(meeting.getParticipants().get(i).getName() + ", ");
        }
    }

    public void printProtocol(Meeting meeting) {
        for (String protocol : meeting.getJournal().getProtocol()) {
            System.out.println("* " + protocol);
        }
    }

}