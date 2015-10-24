package printers;

import companies.Meeting;
import persons.Associate;
import persons.Family;
import persons.FamilyMember;
import persons.Person;

import java.util.ArrayList;

public class PrintPerson implements Printable {

    protected <T extends Person> void printName(T person) {
        System.out.println("Name: " + person.getName());
    }

    protected <T extends Person> void printBirthday(T person) {
        System.out.println("Birthday: " + person.getBirthday());
    }

    //for future sub-classes, input else if instanceof
    @Override
    public <T> void printInfo(T t) {
        if (t instanceof Associate) {
            System.out.println("\n" + ((Associate) t).getName() + " Contact Info: ");
            System.out.println("- Birthdate: " + ((Associate) t).getBirthday());
            System.out.println("- Email: " + ((Associate) t).getContactInfo().getEmail());
            System.out.println("- Address: " + ((Associate) t).getContactInfo().getAddress());
            System.out.println("- Phone Number: " + ((Associate) t).getContactInfo().getPhoneNumber());
            System.out.println("- Company: " + ((Associate) t).getCompany().getName());
            System.out.println("- Position: " + ((Associate) t).getPosition());
            if (!(((Associate) t).getFamilyMembers() == null)) {
                for (FamilyMember familyMember : (((Associate) t).getFamilyMembers())) {
                    if (familyMember.getFamily().equals(Family.SPOUSE)) {
                        System.out.println("- Spouse: " + familyMember.getName());
                    }
                    if (familyMember.getFamily().equals(Family.CHILD)) {
                        System.out.println("- Child: " + familyMember.getName());
                    }
                }
            }
            if (!(((Associate) t).getTags() == null)) {
                System.out.println("- Tags: " + ((Associate) t).getTags());
            }
            if (!(((Associate) t).getMeetings() == null)) {
                System.out.println("- Meetings Planned");
                for (Meeting meetings : ((Associate) t).getMeetings()) {
                    System.out.println("Start Date: " + meetings.getStartDate()
                            + ". Topic: " + meetings.getTopic());
                }
            }
        }
        System.out.println();
    }

    public void printPersonList(ArrayList<Associate> associates) {
        int lister = 0;
        for (Associate person : associates) {
            System.out.println((lister + 1) + ". [" + person.getCompany().getName() + "] " + person.getName());
            lister++;
        }
    }

    // TODO fixa print för family.

}