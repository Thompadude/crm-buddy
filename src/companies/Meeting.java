package companies;

import persons.Associate;

import java.time.LocalDate;
import java.util.ArrayList;

public class Meeting {

    private Journal journal;
    private ArrayList<Associate> participants;
    private String topic;
    private LocalDate startDate;
    private LocalDate endDate;

    public Meeting(String topic, ArrayList<Associate> participants, LocalDate startDate, LocalDate endDate) {
        this.topic = topic;
        this.participants = participants;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
		this.journal = journal;
	}

	public ArrayList<Associate> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Associate> participants) {
		this.participants = participants;
	}

	public String getTopic() {
        return topic;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }
}