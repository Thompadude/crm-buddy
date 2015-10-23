package printers;

import companies.Meeting;
import persons.Associate;
import persons.Person;

import java.util.ArrayList;

public class PrintPerson implements Printable {

    public <T extends Person> void printName(T person) {
        System.out.println("Name: " + person.getName());
    }

    public <T extends Person> void printBirthday(T person) {
        System.out.println("Birthday: " + person.getBirthday());
    }

    //for future sub-classes, input else if instanceof
    @Override
    public <T> void printInfo(T t) {
        if (t instanceof Associate) {
            System.out.println(((Associate) t).getName() + " Contact Info: ");
            System.out.println("- Email: " + ((Associate) t).getContactInfo().getEmail());
            System.out.println("- Phone Number: " + ((Associate) t).getContactInfo().getPhoneNumber());
            System.out.println("- Address: " + ((Associate) t).getContactInfo().getAddress());
            System.out.println("- Company: " + ((Associate) t).getCompany());
            System.out.println("- Tags: " + ((Associate) t).getTags());
            if (!(((Associate) t).getMeetings() == null)) {
                System.out.println("- Meetings Planned");
                for (Meeting meetings : ((Associate) t).getMeetings()) {
                    System.out.println("Topic: " + meetings.getTopic());
                }
            }
        }
    }

    public void printPersonList(ArrayList<Associate> associates) {
        int lister = 0;
        for (Associate person : associates) {
            System.out.println((lister + 1) + "[ " + person.getCompany().getName() + " ]\t" + person.getName());
            lister++;
        }
    }

    // TODO fixa print för family.

}