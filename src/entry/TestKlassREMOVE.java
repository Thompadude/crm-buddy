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
        // todo FOR TESTING PURPOSES. DELETE THESE!
        myCompany.addEmployee(new Associate("Kalle Kula", LocalDate.now(), myCompany, "Boss",
                new ContactInfo("boss@boss.com", "Boss Street", "Boss123")));
        myCompany.addEmployee(new Associate("Johan Falk", LocalDate.now(), myCompany, "Hemlig Polis",
                new ContactInfo("joahn@falk.com", "Göteborg", "911")));
        myCompany.addEmployee(new Associate("Snygg-Lisa", LocalDate.now(), myCompany, "Fluffer",
                new ContactInfo("xxx@com.com", "Bajsgatan", "112")));
        myCompany.addEmployee(new Associate("Snygg-Lisa", LocalDate.now(), myCompany, "Fluffer",
                new ContactInfo("xxx@com.com", "Bajsgatan", "112")));
        myCompany.addEmployee(new Associate("Snygg-Lisa", LocalDate.now(), myCompany, "Fluffer",
                new ContactInfo("xxx@com.com", "Bajsgatan", "112")));
        myCompany.addEmployee(new Associate("Snygg-Lisa", LocalDate.now(), myCompany, "Fluffer",
                new ContactInfo("xxx@com.com", "Bajsgatan", "112")));

        Company telia = new Company("Telia", new ContactInfo("telia@telia.com", "Teliagatan", "031-123456789"));
        Company volvo = new Company("Volvo", new ContactInfo("volvo@volvo.com", "Volvogatan", "031-321654987"));
        myCompany.addAssociatedCompany(telia);
        myCompany.addAssociatedCompany(volvo);

        myCompany.addBusinessAssociate(new Associate("Davoda", LocalDate.now(), telia, "Skurk",
                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123")));
        myCompany.addBusinessAssociate(new Associate("Räven", LocalDate.now(), telia, "Hund",
                new ContactInfo("hund@räv.com", "Skogen", "Saknar telefonnummer")));
        myCompany.addBusinessAssociate(new Associate("Bös-Gubenn", LocalDate.now(), volvo, "Bösare",
                new ContactInfo("bös@bös.bös", "Bösgatan", "Nej")));
        myCompany.addBusinessAssociate(new Associate("Bös-Gubenn", LocalDate.now(), volvo, "Bösare",
                new ContactInfo("bös@bös.bös", "Bösgatan", "Nej")));
        myCompany.addBusinessAssociate(new Associate("Bös-Gubenn", LocalDate.now(), volvo, "Bösare",
                new ContactInfo("bös@bös.bös", "Bösgatan", "Nej")));
        myCompany.addBusinessAssociate(new Associate("Bös-Gubenn", LocalDate.now(), volvo, "Bösare",
                new ContactInfo("bös@bös.bös", "Bösgatan", "Nej")));

        Associate associateA = new Associate("TESTA DENNA FÖR FAMILJ", LocalDate.now(), telia, "Skurk",
                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate associateB = new Associate("Davoda", LocalDate.now(), telia, "Skurk",
                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate associateC = new Associate("Davoda", LocalDate.now(), telia, "Skurk",
                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate associateD = new Associate("Davoda", LocalDate.now(), telia, "Skurk",
                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate associateE = new Associate("Davoda", LocalDate.now(), telia, "Skurk",
                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate associateF = new Associate("Davoda", LocalDate.now(), telia, "Skurk",
                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate associateG = new Associate("Davoda", LocalDate.now(), telia, "Skurk",
                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate associateH = new Associate("Davoda", LocalDate.now(), telia, "Skurk",
                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));

        myCompany.addEmployee(associateA);

        ArrayList<FamilyMember> familyMembers = new ArrayList<>();
        FamilyMember frugan = new FamilyMember("Lisa", LocalDate.now(), Family.SPOUSE);
        FamilyMember ungen = new FamilyMember("Unge", LocalDate.now(), Family.CHILD);
        FamilyMember ungenb = new FamilyMember("Unge2", LocalDate.now(), Family.CHILD);
        FamilyMember ungenbb = new FamilyMember("Unge3", LocalDate.now(), Family.CHILD);
        FamilyMember ungenbbb = new FamilyMember("Unge4", LocalDate.now(), Family.CHILD);
        FamilyMember ungenbbbb = new FamilyMember("Unge5", LocalDate.now(), Family.CHILD);

        familyMembers.add(frugan);
        familyMembers.add(ungen);
        familyMembers.add(ungenb);
        familyMembers.add(ungenbb);
        familyMembers.add(ungenbbb);
        familyMembers.add(ungenbbbb);

        associateA.setFamilyMembers(familyMembers);

        // String[] testaTagsARrray = {"bösa", "näsa", "apa"};
        ArrayList<String> testaTagsARrray = new ArrayList<>();
        testaTagsARrray.add("jhej");
        testaTagsARrray.add("asfasdfasf");
        testaTagsARrray.add("adasdasd");

        associateA.setTags(testaTagsARrray);

        Associate businessAssA = new Associate("Davoda", LocalDate.now(), telia, "Skurk",
                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate businessAssB = new Associate("Davoda", LocalDate.now(), telia, "Skurk",
                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate businessAssC = new Associate("Davoda", LocalDate.now(), telia, "Skurk",
                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate businessAssD = new Associate("Davoda", LocalDate.now(), telia, "Skurk",
                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate businessAssE = new Associate("Davoda", LocalDate.now(), telia, "Skurk",
                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate businessAssF = new Associate("Davoda", LocalDate.now(), telia, "Skurk",
                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate businessAssG = new Associate("Davoda", LocalDate.now(), telia, "Skurk",
                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate businessAssH = new Associate("Davoda", LocalDate.now(), telia, "Skurk",
                new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));

        ArrayList<Associate> tempEmployeee = new ArrayList<Associate>();
        tempEmployeee.add(associateA);
        tempEmployeee.add(associateB);
        tempEmployeee.add(businessAssA);
        tempEmployeee.add(businessAssD);
        tempEmployeee.add(businessAssD);
        tempEmployeee.add(businessAssD);
        tempEmployeee.add(associateG);
        tempEmployeee.add(associateH);

        LocalDateTime startDate = LocalDateTime.of(2015, 10, 10, 10, 10);
        LocalDateTime endDate = LocalDateTime.of(2015, 12, 10, 10, 10);
        LocalDateTime testDate = LocalDateTime.of(2015, 9, 10, 10, 10);

        Meeting meetingA = new Meeting("topic", tempEmployeee, startDate, endDate);
        Meeting meetingB = new Meeting("topic", tempEmployeee, LocalDateTime.now(), LocalDateTime.now());
        Meeting meetingC = new Meeting("topic", tempEmployeee, LocalDateTime.now(), LocalDateTime.now());
        Meeting meetingD = new Meeting("topic", tempEmployeee, LocalDateTime.now(), LocalDateTime.now());
        Meeting meetingE = new Meeting("topic", tempEmployeee, LocalDateTime.now(), LocalDateTime.now());
        ArrayList<Meeting> arrayListAvMeetings = new ArrayList<>();
        arrayListAvMeetings.add(meetingA);
        arrayListAvMeetings.add(meetingB);
        arrayListAvMeetings.add(meetingC);
        arrayListAvMeetings.add(meetingD);
        arrayListAvMeetings.add(meetingE);
        myCompany.createMeetings();
        myCompany.getMeetings().add(meetingA);
        myCompany.getMeetings().add(meetingB);
        myCompany.getMeetings().add(meetingC);
        myCompany.getMeetings().add(meetingD);
        myCompany.getMeetings().add(meetingE);
        associateA.setMeetings(arrayListAvMeetings);

        // todo DENNA FUNKAR!
        boolean test = associateA.isAvailableForMeeting(testDate);
        System.out.println(test);
        // todo END TESTING. DELETE THESE!
    }

}