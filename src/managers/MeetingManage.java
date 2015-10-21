package managers;

import java.time.LocalDate;
import java.util.ArrayList;

import companies.Journal;
import companies.Meeting;
import persons.Associate;

public class MeetingManage {

	//ArrayList<Associate> participants is stored in UI 
	public Meeting createMeeting(String topic, ArrayList<Associate> participants, LocalDate startDate,
			LocalDate endDate) {	
		return new Meeting(topic, participants, startDate, endDate);
	}

	public void addParticipant(Meeting meeting, Associate associate) {
		
//		Detta ska flyttas
//		if (meeting.getParticipants() == null) {
//			meeting. = new ArrayList<Associate>();
//		}
		meeting.getParticipants().add(associate);
	}
	
	public void removeParticipant(Meeting meeting, String searchName) {
		for(int i = 0; i < meeting.getParticipants().size(); i++ ) {
			if(searchName.toLowerCase().equals(meeting.getParticipants().get(i).getName().toLowerCase())) {
				meeting.getParticipants().remove(i);
			}
		}
	}
	//TODO if-statements for journal rules
	public void createJournal(Meeting meeting, ArrayList<String> protocol) {
		meeting.setJournal(new Journal(protocol));
	}
}
