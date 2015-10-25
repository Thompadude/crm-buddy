package printers;

import companies.Meeting;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintMeeting implements Printable {


	public void printMeetingList(ArrayList<Meeting> meetings) {
		System.out.println("Date\t\t\t\t\t\tTopic");
		System.out.println("----\t\t\t\t\t\t-----");
		int lister = 1;
		for(Meeting meeting : meetings) {
			System.out.println(lister + ". " + meeting.getStartDate() +
								"   " + meeting.getTopic());
			lister++;
		}
	}

	@Override
	public <T> void printInfo(T t) {
		if( t instanceof Meeting){
			System.out.println("Date: " + ((Meeting) t).getStartDate().toString() + " - " + 
							((Meeting) t).getEndDate().toString());
			System.out.println("Topic: " + ((Meeting) t).getTopic());
			System.out.print("---Participants--- ");
			printParticipants(((Meeting)t));
			System.out.println("\n------------------");
			System.out.println("Journal :");
			if (((Meeting) t).getJournal() != null) {
				printProtocol(((Meeting)t));
			} else {
				System.out.println("---No journal---");
			}
		}
	}

	protected void printParticipants(Meeting meeting){
		for(int i=0; i<meeting.getParticipants().size(); i++){
			if((i % 3) == 0){
				System.out.println();
			}
				System.out.print("[" + meeting.getParticipants().get(i).getCompany().getName() + "]" +
						meeting.getParticipants().get(i).getName() + ", ");
		}
	}

	protected void printProtocol(Meeting meeting){
		for (String protocol : meeting.getJournal().getProtocol()) {
			System.out.println("* " + protocol);
		}
	} 

	public void printNewlyCreatedMeeting(Meeting newMeeting, Scanner stringScanner) {
		System.out.println("\nNew meeting created with topic: " + newMeeting.getTopic()
				+ "\nStart Date: " + newMeeting.getStartDate().toString()
				+ "\nEnd Date: " + newMeeting.getEndDate().toString()
				+ "\n\nPress any key to continue...");
		stringScanner.nextLine();
	}
}
