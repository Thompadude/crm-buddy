package printers;

import companies.Meeting;

import java.util.ArrayList;

public class PrintMeeting implements Printable {

	
	public void printMeetingList(ArrayList<Meeting> meetings) {
		System.out.println("Date\t\t    Topic");
		System.out.println("----\t\t    -----");
		for(Meeting meeting : meetings) {
			System.out.println(meeting.getStartDate() +
								"   " + meeting.getTopic());
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
	
	public void printParticipants(Meeting meeting){
		
		for(int i=0; i<meeting.getParticipants().size(); i++){
			
			if((i % 3) == 0){
				System.out.println();
			}
			
				System.out.print("[" + meeting.getParticipants().get(i).getCompany().getName() + "]" +
									meeting.getParticipants().get(i).getName() + ", ");
		}
		
	}
	
	public void printProtocol(Meeting meeting){
		for (String protocol : meeting.getJournal().getProtocol()) {
			System.out.println("* " + protocol);
		}
	} 
	
	
}
