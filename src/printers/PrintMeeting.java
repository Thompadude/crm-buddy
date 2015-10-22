package printers;

import companies.Meeting;

public class PrintMeeting implements Printable {

	@Override
	public <T> void printInfo(T t) {
		
		if( t instanceof Meeting){
			
			System.out.print("Date: " + ((Meeting) t).getStartDate().toString() + " - " + 
							((Meeting) t).getEndDate().toString());
			System.out.println("\t " + ((Meeting) t).getTopic());
			
			System.out.println("Participants: ");
			printParticipants(((Meeting)t));
			
			System.out.println("Protokoll :");
			printProtocol(((Meeting)t));
			
		}
		
	}
	
	public void printParticipants(Meeting meeting){
		
		for(int i=0; i<meeting.getParticipants().size(); i++){
			
			if((i % 3) == 0){
				System.out.println();
			}
			
				System.out.print(meeting.getParticipants().get(i).getName() + ", ");
		}
		
	}
	
	public void printProtocol(Meeting meeting){
		for (String protocol : meeting.getJournal().getProtocol()) {
			System.out.println("* " + protocol);
		}
	} 
	
	
}
