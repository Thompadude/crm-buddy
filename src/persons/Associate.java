package persons;

import companies.Company;
import companies.Meeting;
import contactInfo.ContactInfo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Associate extends Person {

    private ContactInfo contactInfo;
    private Company company;
    private String position;
    private ArrayList<String> tags;
    private ArrayList<Meeting> meetings;
    private ArrayList<FamilyMember> familyMembers;
    // Used for sorting to be able to print upcoming birthdays within five days.
    private long birthDateCompareIndex;

    public Associate(String name, LocalDate birthDate, Company company, String position, ContactInfo contactInfo) {
        super(name, birthDate);
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

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }

    public void addMeeting(Meeting meeting) {
        this.meetings.add(meeting);
    }

    public void setMeetings(ArrayList<Meeting> meetings) {
        this.meetings = meetings;
    }

    /**
     * For later development. Checks if user is available when creating a new meeting.
     */
    public boolean isAvailableForMeeting(LocalDateTime preferedStartDate) {
        for (Meeting meeting : meetings) {
            if (preferedStartDate.isBefore(meeting.getEndDate()) && preferedStartDate.isAfter(meeting.getStartDate())) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(ArrayList<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public long getBirthDateCompareIndex() {
        return birthDateCompareIndex;
    }

    public void setBirthDateCompareIndex(long birthDateCompareIndex) {
        this.birthDateCompareIndex = birthDateCompareIndex;
    }

}