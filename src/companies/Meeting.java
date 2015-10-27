package companies;

import persons.Associate;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Meeting implements java.io.Serializable {

    private Journal journal;
    private ArrayList<Associate> participants;
    private String topic;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Meeting(String topic, ArrayList<Associate> participants, LocalDateTime startDate, LocalDateTime endDate) {
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

    public String getTopic() {
        return topic;
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public LocalDateTime getEndDate() {
        return this.endDate;
    }

}