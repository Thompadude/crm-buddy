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
    // TODO För att kunna lista vilka möten en person har varit på samt för att undvika dubbelbokning.
    private ArrayList<Meeting> meetings;
    private ArrayList<FamilyMember> familyMembers;

    public Associate(String name, LocalDate birthDate, Company company,
                     String position, ContactInfo contactInfo) {
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

/*    public void setTags(String... tags) {
        for (String tag : tags) {
            this.tags.add(tag);
        }
    }
*/

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(ArrayList<Meeting> meetings) {
        this.meetings = meetings;
    }

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

}