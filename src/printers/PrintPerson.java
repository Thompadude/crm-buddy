package printers;

import companies.Meeting;
import managers.ObjectManage;
import persons.Associate;
import persons.Family;
import persons.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
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
        ObjectManage objectManage = new ObjectManage();
        if (t instanceof Associate) {
            System.out.println("\n" + ((Associate) t).getName() + " Contact Info: ");
            System.out.println("- Birthdate: " + ((Associate) t).getBirthday());
            System.out.println("- Email: " + ((Associate) t).getContactInfo().getEmail());
            System.out.println("- Address: " + ((Associate) t).getContactInfo().getAddress());
            System.out.println("- Phone Number: " + ((Associate) t).getContactInfo().getPhoneNumber());
            System.out.println("- Company: " + ((Associate) t).getCompany().getName());
            System.out.println("- Position: " + ((Associate) t).getPosition());
            if (!objectManage.getErrorManage().catchArrayListNullPointerException(((Associate) t).getFamilyMembers())) {
                System.out.println("\n--- Family ---");
                for (int i = 0; i < (((Associate) t).getFamilyMembers().size()); i++) {
                    if (((Associate) t).getFamilyMembers().get(i).getFamily().equals(Family.SPOUSE)) {
                        if (i == 0) {
                            System.out.println("- Spouse ");
                        }
                        System.out.print(((Associate) t).getFamilyMembers().get(i).getName() + ", born "
                                + ((Associate) t).getFamilyMembers().get(i).getBirthday());
                    }

                }
                for (int i = 0; i < (((Associate) t).getFamilyMembers().size()); i++) {
                    if (i == 0) {
                        System.out.println("\n- Children ");
                    }
                    if (((Associate) t).getFamilyMembers().get(i).getFamily().equals(Family.CHILD)) {
                        System.out.println(((Associate) t).getFamilyMembers().get(i).getName() + ", born "
                                + ((Associate) t).getFamilyMembers().get(i).getBirthday());
                    }
                }
                System.out.println("-------------");
            }
            if (!objectManage.getErrorManage().catchArrayListNullPointerException(((Associate) t).getTags())) {
                System.out.println("\n- Tags: " + ((Associate) t).getTags());
            }
            if (!objectManage.getErrorManage().catchArrayListNullPointerException(((Associate) t).getMeetings())) {
                    System.out.println("\n- Meetings Planned");
                for (Meeting meetings : ((Associate) t).getMeetings()) {
                    if (meetings.getEndDate().isAfter(LocalDateTime.now())) {
                        System.out.println("Start Date: " + meetings.getStartDate()
                                + ". Topic: " + meetings.getTopic());
                    }
                }
                    System.out.println("\n- Past Meetings");
                for (Meeting meetings : ((Associate) t).getMeetings()) {
                    if (meetings.getEndDate().isBefore(LocalDateTime.now())) {
                        System.out.println("Start Date: " + meetings.getStartDate()
                                + ". Topic: " + meetings.getTopic());
                    }
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