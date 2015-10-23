package persons;

import companies.Company;
import companies.MyCompany;
import contactInfo.ContactInfo;
import companies.Meeting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Associate extends Person {

    private ContactInfo contactInfo;
    private Company company;
    private String position;
    private ArrayList<String> tags;
    //  För att kunna lista vilka möten en person har varit på samt för att undvika dubbelbokning.
    private ArrayList<Meeting> meetings;

    public Associate(int id, String name, LocalDate birthDate, Company company,
                     String position, ContactInfo contactInfo) {
        super(id, name, birthDate);
        this.company = company;
        this.position = position;
        this.contactInfo = contactInfo;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public Company getCompany() {
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
    
    public void setPosition(String position){
    	this.position = position;
    }

    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }

    public boolean isAvailableForMeeting(LocalDateTime preferedStartDate) {
        // TODO kod här för att kolla om personen är ledig eller inte (Kolla sin egna arraylist av meetings)
        for (Meeting meeting : meetings) {
            if (preferedStartDate.isBefore(meeting.getEndDate()) && preferedStartDate.isAfter(meeting.getStartDate())) {
                return false;
            }
        }
        return true;
    }

}