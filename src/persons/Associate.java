package persons;

import companies.MyCompany;
import companies.Meeting;

import java.time.LocalDate;
import java.util.ArrayList;

public class Associate extends Person {

    private ContactInfo contactInfo;
    private MyCompany company;
    private String position;
    private ArrayList<String> tags;
    //  För att kunna lista vilka möten en person har varit på samt för att undvika dubbelbokning.
    private ArrayList<Meeting> meetings;

    public Associate(int id, String name, LocalDate birthday, MyCompany company,
                     String position, ContactInfo contactInfo) {
        super(id, name, birthday);
        this.company = company;
        this.position = position;
        this.contactInfo = contactInfo;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public MyCompany getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(String... tags) {
        for (String tag : tags) {
            this.tags.add(tag);
        }
    }

    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }

    public boolean isAvailableForMeeting(LocalDate preferedStartDate) {
        // TODO kod här för att kolla om personen är ledig eller inte (Kolla sin egna arraylist av meetings)
        for (Meeting meeting : meetings) {
            if (preferedStartDate.isBefore(meeting.getEndDate()) && preferedStartDate.isAfter(meeting.getStartDate())) {
                return false;
            }
        }
        return true;
    }

}