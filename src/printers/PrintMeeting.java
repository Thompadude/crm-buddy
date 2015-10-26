package printers;

import companies.Meeting;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintMeeting implements Printable {

    String meetingStartDate, meetingEndDate;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public void printMeetingList(ArrayList<Meeting> meetings) {
        System.out.println("\nDate & start time\t\tTopic");
        System.out.println("-------------------\t\t-----");
        int lister = 1;
        for (Meeting meeting : meetings) {
            meetingStartDate = meeting.getStartDate().format(dateTimeFormatter);
            System.out.println(lister + ". " + meetingStartDate +
                    "\t\t" + meeting.getTopic());
            lister++;
        }
    }

    @Override
    public <T> void printInfo(T t) {
        if (t instanceof Meeting) {
            meetingStartDate = ((Meeting) t).getStartDate().format(dateTimeFormatter);
            meetingEndDate = ((Meeting) t).getEndDate().format(dateTimeFormatter);
            System.out.println("\n-Topic-\n" + ((Meeting) t).getTopic());
            System.out.println("\n-Length-\n" + meetingStartDate + " - " + meetingEndDate);
            System.out.print("\n-Participants-");
            printParticipants(((Meeting) t));
            System.out.println("\n\n-Journal-");
            if (((Meeting) t).getJournal() != null) {
                printProtocol(((Meeting) t));
            } else {
                System.out.println("* No journal created yet.");
            }
        }
    }

    protected void printParticipants(Meeting meeting) {
        for (int i = 0; i < meeting.getParticipants().size(); i++) {
            if ((i % 3) == 0) {
                System.out.println();
            }
            System.out.print("[" + meeting.getParticipants().get(i).getCompany().getName() + "]" +
                    meeting.getParticipants().get(i).getName() + ", ");
        }
    }

    protected void printProtocol(Meeting meeting) {
        for (String protocol : meeting.getJournal().getProtocol()) {
            System.out.println("* " + protocol);
        }
    }

    public void printNewlyCreatedMeeting(Meeting newMeeting, Scanner stringScanner) {
        meetingStartDate = newMeeting.getStartDate().format(dateTimeFormatter);
        meetingEndDate = newMeeting.getEndDate().format(dateTimeFormatter);
        System.out.println("\nNew meeting created with topic: " + newMeeting.getTopic()
                + "\nStart Date: " + meetingStartDate
                + "\nEnd Date: " + meetingEndDate
                + "\n\nPress any key to continue...");
        stringScanner.nextLine();
    }

}
