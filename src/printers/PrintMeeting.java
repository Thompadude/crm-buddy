package printers;

import companies.Meeting;
import managers.ObjectManage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintMeeting implements Printable {

    String meetingStartDate, meetingEndDate;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

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

    public void printMeetingList(ArrayList<Meeting> meetings) {
        if (!(meetings.isEmpty())) {
            System.out.println("Date & start time\t\tTopic");
            System.out.println("-------------------\t\t-----");
        }

        int lister = 1;

        for (Meeting meeting : meetings) {
            meetingStartDate = meeting.getStartDate().format(dateTimeFormatter);
            System.out.println(lister + ". " + meetingStartDate +
                    "\t\t" + meeting.getTopic());
            lister++;
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

    public void printTodaysMeetings(ArrayList<Meeting> meetings, ObjectManage objectManage) {
        LocalDate todaysDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDate meetingStartDateLocalDate;

        if (!objectManage.getErrorManage().catchArrayListNullPointerException(meetings)) {

            for (int i = 0; i < meetings.size(); i++) {
                meetingStartDate = meetings.get(i).getStartDate().format(dateTimeFormatter);
                meetingStartDateLocalDate = meetings.get(i).getStartDate().toLocalDate();

                if (meetingStartDateLocalDate.equals(todaysDate)) {
                    objectManage.getWaitingMechanics().wait(1000);
                    System.out.println("\n-------------");
                    System.out.println("Meeting today at " + meetingStartDate + " Topic: " + meetings.get(i).getTopic());
                    System.out.print("-Participants-");
                    printParticipants(meetings.get(i));
                    System.out.println("\n-------------");
                }
            }
        }
        objectManage.getWaitingMechanics().wait(2000);
        System.out.println();
    }

    private void printProtocol(Meeting meeting) {
        for (String protocol : meeting.getJournal().getProtocol()) {
            System.out.println("* " + protocol);
        }
    }

    private void printParticipants(Meeting meeting) {
        for (int i = 0; i < meeting.getParticipants().size(); i++) {

            if ((i % 3) == 0) {
                System.out.println();
            }

            System.out.print("[" + meeting.getParticipants().get(i).getCompany().getName() + "]" +
                    meeting.getParticipants().get(i).getName() + ", ");
        }
    }

}