package entry;

import companies.Company;
import companies.Meeting;
import companies.MyCompany;
import contactInfo.ContactInfo;
import persons.Associate;
import persons.Family;
import persons.FamilyMember;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestKlassREMOVE {

    public void TestKlass(MyCompany myCompany) {
        // Created temporary Business Companies
        Company telia = new Company("Telia", new ContactInfo("telia@telia.se", "Teliagatan", "031-123456789"));
        Company volvo = new Company("Volvo", new ContactInfo("volvo@volvo.com", "Volvogatan", "031-321654987"));
        myCompany.addAssociatedCompany(telia);
        myCompany.addAssociatedCompany(volvo);

        // Created temporary Employees
        myCompany.addEmployee(new Associate("Patrik Andersson", LocalDate.of(1985, 10, 31), myCompany, "Board member",
                new ContactInfo("Patrik.A@apple.com", "Fiskaregatan 31", "070-1234567")));
        myCompany.addEmployee(new Associate("Joel Nilsson", LocalDate.of(1986, 01, 01), myCompany, "Board member",
                new ContactInfo("Joel.N@apple.com", "SwagStreet 12", "08-7020090")));
        myCompany.addEmployee(new Associate("Thomas Lansing", LocalDate.of(1984, 10, 24), myCompany, "Board member",
                new ContactInfo("Thomas.L@apple.com", "DebuggerLane 2", "031-7730000")));


        Associate associateA = new Associate("Brad Pitt(has a family)", LocalDate.of(1963, 12, 18), telia, "Front man",
                new ContactInfo("pitt@telia.se", "Fury Street", "010-131313"));
        myCompany.addBusinessAssociate(associateA);

        // Created temporay Business associates
        myCompany.addBusinessAssociate(new Associate("Jürgen Klinsman", LocalDate.of(1973, 10, 25), telia, "CEO",
                new ContactInfo("ceo@telia.se", "Skurkgatan 2", "031-665544")));
        myCompany.addBusinessAssociate(new Associate("Alicia Vikander", LocalDate.of(1988, 10, 30), telia, "Economics",
                new ContactInfo("alicia@telia.se", "Machinastreet 2", "010-282828")));
//        myCompany.addBusinessAssociate(new Associate("Brad Pitt(has a family)", LocalDate.of(1963, 12, 18), telia, "Front man",
//                new ContactInfo("pitt@telia.se", "Fury Street", "010-131313")));
        myCompany.addBusinessAssociate(new Associate("Dolph Lundgren", LocalDate.of(1957, 11, 03), volvo, "CEO",
                new ContactInfo("doffe@volvo.com", "Hansgatan 1", "020-101010")));
        myCompany.addBusinessAssociate(new Associate("Beyoncé Knowles-Carter", LocalDate.of(1981, 9, 04), volvo, "Staff",
                new ContactInfo("singleLady@volvi.com", "Broadway 10", "031-202022")));
        myCompany.addBusinessAssociate(new Associate("Kim Kardashian", LocalDate.of(1980, 10, 21), volvo, "Support",
                new ContactInfo("kim@volvo.com", "Californialane 11", "066-884422")));

        ArrayList<FamilyMember> familyMembers = new ArrayList<>();
        FamilyMember frugan = new FamilyMember("Angelina Jolie", LocalDate.of(1975, 06, 04), Family.SPOUSE);
        FamilyMember ungen = new FamilyMember("Billy", LocalDate.of(1996, 10, 28), Family.CHILD);
        FamilyMember ungenb = new FamilyMember("Johnny", LocalDate.of(1998, 01, 15), Family.CHILD);
        FamilyMember ungenbb = new FamilyMember("Lenny", LocalDate.of(2000, 02, 02), Family.CHILD);
        FamilyMember ungenbbb = new FamilyMember("Tommy", LocalDate.of(2005, 8, 11), Family.CHILD);
        FamilyMember ungenbbbb = new FamilyMember("Sonny", LocalDate.of(2011, 3, 29), Family.CHILD);

        familyMembers.add(frugan);
        familyMembers.add(ungen);
        familyMembers.add(ungenb);
        familyMembers.add(ungenbb);
        familyMembers.add(ungenbbb);
        familyMembers.add(ungenbbbb);

        associateA.setFamilyMembers(familyMembers);
        ArrayList<String> testaTagsARrray = new ArrayList<>();
        testaTagsARrray.add("TestTag1");
        testaTagsARrray.add("TestTag2");
        testaTagsARrray.add("TestTag3");

        associateA.setTags(testaTagsARrray);


        // todo FOR TESTING PURPOSES. DELETE THESE!
//        myCompany.addEmployee(new Associate("David", LocalDate.now(), myCompany, "Fluffer",
//                new ContactInfo("xxx@com.com", "Bajsgatan", "112")));
//        myCompany.addEmployee(new Associate("Erik", LocalDate.now(), myCompany, "Fluffer",
//                new ContactInfo("xxx@com.com", "Bajsgatan", "112")));
//        myCompany.addEmployee(new Associate("Johan Falk", LocalDate.now(), myCompany, "Fluffer",
//                new ContactInfo("xxx@com.com", "Bajsgatan", "112")));



//
//        Associate associateB = new Associate("EmployeeTEST Martin", LocalDate.now(), telia, "Skurk",
//                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
//        Associate associateC = new Associate("EmployeeTest Niklas", LocalDate.now(), telia, "Skurk",
//                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
//        Associate associateD = new Associate("EmployeeTest Olof", LocalDate.now(), telia, "Skurk",
//                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
//        Associate associateE = new Associate("EmployeeTest Petter", LocalDate.now(), telia, "Skurk",
//                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
//        Associate associateF = new Associate("EmployeeTest Quitus", LocalDate.now(), telia, "Skurk",
//                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
//        Associate associateG = new Associate("EmployeeTest Rudolf", LocalDate.now(), telia, "Skurk",
//                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
//        Associate associateH = new Associate("EmployeeTest Sigurd", LocalDate.now(), telia, "Skurk",
//                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));

//        myCompany.addBusinessAssociate(associateA);




//        Associate businessAssA = new Associate("hmm1", LocalDate.now(), telia, "Skurk",
//                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
//        Associate businessAssB = new Associate("hmm2", LocalDate.now(), telia, "Skurk",
//                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
//        Associate businessAssC = new Associate("hmm3", LocalDate.now(), telia, "Skurk",
//                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
//        Associate businessAssD = new Associate("hmm4", LocalDate.now(), telia, "Skurk",
//                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
//        Associate businessAssE = new Associate("hmm5", LocalDate.now(), telia, "Skurk",
//                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
//        Associate businessAssF = new Associate("hmm6", LocalDate.now(), telia, "Skurk",
//                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
//        Associate businessAssG = new Associate("hmm7", LocalDate.now(), telia, "Skurk",
//                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
//        Associate businessAssH = new Associate("hmm8", LocalDate.now(), telia, "Skurk",
//                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));

//        ArrayList<Associate> tempEmployeee = new ArrayList<Associate>();
//        tempEmployeee.add(associateA);
//        tempEmployeee.add(associateB);
//        tempEmployeee.add(businessAssA);
//        tempEmployeee.add(businessAssD);
//        tempEmployeee.add(businessAssD);
//        tempEmployeee.add(businessAssD);
//        tempEmployeee.add(associateG);
//        tempEmployeee.add(associateH);

//        LocalDateTime startDate = LocalDateTime.of(2015, 10, 10, 10, 10);
//        LocalDateTime endDate = LocalDateTime.of(2015, 12, 10, 10, 10);
//        LocalDateTime testDate = LocalDateTime.of(2015, 9, 10, 10, 10);
//
//        Meeting meetingA = new Meeting("TestMöte1", tempEmployeee, startDate, endDate);
//        Meeting meetingB = new Meeting("TestMöte2", tempEmployeee, LocalDateTime.now(), LocalDateTime.now());
//        Meeting meetingC = new Meeting("TestMöte3", tempEmployeee, LocalDateTime.now(), LocalDateTime.now());
//        Meeting meetingD = new Meeting("TestMöte4", tempEmployeee, LocalDateTime.now(), LocalDateTime.now());
//        Meeting meetingE = new Meeting("TestMöte5", tempEmployeee, LocalDateTime.now(), LocalDateTime.now());
//        ArrayList<Meeting> arrayListAvMeetings = new ArrayList<>();
//        arrayListAvMeetings.add(meetingA);
//        arrayListAvMeetings.add(meetingB);
//        arrayListAvMeetings.add(meetingC);
//        arrayListAvMeetings.add(meetingD);
//        arrayListAvMeetings.add(meetingE);
//        myCompany.createMeetings();
//        myCompany.getMeetings().add(meetingA);
//        myCompany.getMeetings().add(meetingB);
//        myCompany.getMeetings().add(meetingC);
//        myCompany.getMeetings().add(meetingD);
//        myCompany.getMeetings().add(meetingE);
//        associateA.setMeetings(arrayListAvMeetings);

        // todo DENNA FUNKAR!
//        boolean test = associateA.isAvailableForMeeting(testDate);
//        System.out.println(test);
        // todo END TESTING. DELETE THESE!
    }

}