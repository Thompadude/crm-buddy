package entry;

import companies.Company;
import companies.Journal;
import companies.Meeting;
import companies.MyCompany;
import contactInfo.ContactInfo;
import managers.ObjectManage;
import managers.PrintManage;
import menysystem.ConsoleMenu;
import menysystem.Menu;
import persons.Associate;
import persons.Family;
import persons.FamilyMember;
import persons.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    Scanner stringScanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);
    ObjectManage objectManage = new ObjectManage();
    PrintManage printManage = new PrintManage();
    Menu menu = new ConsoleMenu();
    Menu subMenuEmployee = new ConsoleMenu();
    Menu subMenuAssociate = new ConsoleMenu();
    Menu subMenuMeeting = new ConsoleMenu();
    ArrayList<String> menuAlternatives;

    int input;

    public void mainMenu(MyCompany myCompany) {

        menu.setMenuTitle("Main Menu");

        menuAlternatives = new ArrayList<String>();
        menuAlternatives.add("Create employee");
        menuAlternatives.add("Create business contact");
        menuAlternatives.add("Create meeting");
        menuAlternatives.add("Manage employee");
        menuAlternatives.add("Manage business contact");
        menuAlternatives.add("Manage meeting");
        menuAlternatives.add("Save & Quit system");

        do {
            menu.printMenu(menuAlternatives);
            input = menu.getInput(intScanner);
            mainSwitch(input, myCompany);
        } while (input != menuAlternatives.size());
    }

    public void subMenuEmployee(int choice, MyCompany myCompany) {
        Associate currentPerson = myCompany.getEmployees().get(choice);

        menu.setMenuTitle("Edit and View Employee");
        printManage.getPrintPerson().printInfo(currentPerson);
        menuAlternatives = new ArrayList<String>();
        menuAlternatives.add("Edit name");
        menuAlternatives.add("Edit birthdate");
        menuAlternatives.add("Edit address");
        menuAlternatives.add("Edit e-mail");
        menuAlternatives.add("Edit phonenumber");
        menuAlternatives.add("Edit familymembers");
        menuAlternatives.add("Edit position");
        menuAlternatives.add("Back to main menu");

        do {
            if (myCompany.getEmployees() == null) {
                System.out.println("You dont have any employees yet");
                System.out.println("Press any key to continue...");
                stringScanner.nextLine();
            } else {
                menu.printMenu(menuAlternatives);
                input = menu.getInput(intScanner);
                subMenuEmployeeSwitch(input, myCompany, currentPerson);
            }
        } while (input != menuAlternatives.size() + 1);

    }

    public void subMenuBusinessAssociate(int choice, MyCompany myCompany) {
        Associate currentPerson = myCompany.getEmployees().get(choice);

        menu.setMenuTitle("Edit and View Business associate");
        menuAlternatives = new ArrayList<String>();
        menuAlternatives.add("bizznizz");
        menuAlternatives.add("bizznizz");
        menuAlternatives.add("bizznizz");
        menuAlternatives.add("bizznizz");
        menuAlternatives.add("bizznizz");
        menuAlternatives.add("bizznizz");
        menuAlternatives.add("Back to main menu");

        do {
            menu.printMenu(menuAlternatives);
            input = menu.getInput(intScanner);
            subMenuBusinessSwitch(input, myCompany);
        } while (input != menuAlternatives.size() + 1);

    }

    public void subMenuMeeting(MyCompany myCompany) {
        menu.setMenuTitle("Edit and View Meeting");

        menuAlternatives = new ArrayList<String>();
        menuAlternatives.add("meeting");
        menuAlternatives.add("meeting");
        menuAlternatives.add("meeting");
        menuAlternatives.add("meeting");
        menuAlternatives.add("meeting");
        menuAlternatives.add("meeting");
        menuAlternatives.add("Back to main menu");

        do {
            menu.printMenu(menuAlternatives);
            input = menu.getInput(intScanner);
            subMenuMeetingSwitch(input, myCompany);
        } while (input != menuAlternatives.size() + 1);

    }

    public void mainSwitch(int input, MyCompany myCompany) {

        // todo FOR TESTING PURPOSES. DELETE THESE!
        myCompany.addEmployee(new Associate(0, "Kalle Kula", LocalDate.now(), myCompany, "Boss", new ContactInfo("boss@boss.com", "Boss Street", "Boss123")));
        myCompany.addEmployee(new Associate(0, "Johan Falk", LocalDate.now(), myCompany, "Hemlig Polis", new ContactInfo("joahn@falk.com", "Göteborg", "911")));
        myCompany.addEmployee(new Associate(0, "Snygg-Lisa", LocalDate.now(), myCompany, "Fluffer", new ContactInfo("xxx@com.com", "Bajsgatan", "112")));
        myCompany.addEmployee(new Associate(0, "Snygg-Lisa", LocalDate.now(), myCompany, "Fluffer", new ContactInfo("xxx@com.com", "Bajsgatan", "112")));
        myCompany.addEmployee(new Associate(0, "Snygg-Lisa", LocalDate.now(), myCompany, "Fluffer", new ContactInfo("xxx@com.com", "Bajsgatan", "112")));
        myCompany.addEmployee(new Associate(0, "Snygg-Lisa", LocalDate.now(), myCompany, "Fluffer", new ContactInfo("xxx@com.com", "Bajsgatan", "112")));

        Company telia = new Company("Telia", new ContactInfo("telia@telia.com", "Teliagatan", "031-123456789"));
        Company volvo = new Company("Volvo", new ContactInfo("volvo@volvo.com", "Volvogatan", "031-321654987"));
        myCompany.addAssociatedCompany(telia);
        myCompany.addAssociatedCompany(volvo);

        myCompany.addBusinessAssociate(new Associate(0, "Davoda", LocalDate.now(), telia, "Skurk", new ContactInfo("skurk@skurk.com", "Skrukgatan", "123")));
        myCompany.addBusinessAssociate(new Associate(0, "Räven", LocalDate.now(), telia, "Hund", new ContactInfo("hund@räv.com", "Skogen", "Saknar telefonnummer")));
        myCompany.addBusinessAssociate(new Associate(0, "Bös-Gubenn", LocalDate.now(), volvo, "Bösare", new ContactInfo("bös@bös.bös", "Bösgatan", "Nej")));
        myCompany.addBusinessAssociate(new Associate(0, "Bös-Gubenn", LocalDate.now(), volvo, "Bösare", new ContactInfo("bös@bös.bös", "Bösgatan", "Nej")));
        myCompany.addBusinessAssociate(new Associate(0, "Bös-Gubenn", LocalDate.now(), volvo, "Bösare", new ContactInfo("bös@bös.bös", "Bösgatan", "Nej")));
        myCompany.addBusinessAssociate(new Associate(0, "Bös-Gubenn", LocalDate.now(), volvo, "Bösare", new ContactInfo("bös@bös.bös", "Bösgatan", "Nej")));

        Associate associateA = new Associate(0, "TESTA DENNA FÖR FAMILJ", LocalDate.now(), telia, "Skurk", new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate associateB = new Associate(0, "Davoda", LocalDate.now(), telia, "Skurk", new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate associateC = new Associate(0, "Davoda", LocalDate.now(), telia, "Skurk", new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate associateD = new Associate(0, "Davoda", LocalDate.now(), telia, "Skurk", new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate associateE = new Associate(0, "Davoda", LocalDate.now(), telia, "Skurk", new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate associateF = new Associate(0, "Davoda", LocalDate.now(), telia, "Skurk", new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate associateG = new Associate(0, "Davoda", LocalDate.now(), telia, "Skurk", new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate associateH = new Associate(0, "Davoda", LocalDate.now(), telia, "Skurk", new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));

        myCompany.addEmployee(associateA);

        ArrayList<FamilyMember> familyMembers = new ArrayList<>();
        FamilyMember frugan = new FamilyMember(0, "Lisa", LocalDate.now(), Family.SPOUSE);
        FamilyMember ungen = new FamilyMember(0, "Unge", LocalDate.now(), Family.CHILD);
        FamilyMember ungenb = new FamilyMember(0, "Unge2", LocalDate.now(), Family.CHILD);
        FamilyMember ungenbb = new FamilyMember(0, "Unge3", LocalDate.now(), Family.CHILD);
        FamilyMember ungenbbb = new FamilyMember(0, "Unge4", LocalDate.now(), Family.CHILD);
        FamilyMember ungenbbbb = new FamilyMember(0, "Unge5", LocalDate.now(), Family.CHILD);

        familyMembers.add(frugan);
        familyMembers.add(ungen);
        familyMembers.add(ungenb);
        familyMembers.add(ungenbb);
        familyMembers.add(ungenbbb);
        familyMembers.add(ungenbbbb);

        associateA.setFamilyMembers(familyMembers);

//        String[] testaTagsARrray = {"bösa", "näsa", "apa"};
        ArrayList<String> testaTagsARrray = new ArrayList<>();
        testaTagsARrray.add("jhej");
        testaTagsARrray.add("asfasdfasf");
        testaTagsARrray.add("adasdasd");

        associateA.setTags(testaTagsARrray);

        Associate businessAssA = new Associate(0, "Davoda", LocalDate.now(), telia, "Skurk", new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate businessAssB = new Associate(0, "Davoda", LocalDate.now(), telia, "Skurk", new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate businessAssC = new Associate(0, "Davoda", LocalDate.now(), telia, "Skurk", new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate businessAssD = new Associate(0, "Davoda", LocalDate.now(), telia, "Skurk", new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate businessAssE = new Associate(0, "Davoda", LocalDate.now(), telia, "Skurk", new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate businessAssF = new Associate(0, "Davoda", LocalDate.now(), telia, "Skurk", new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate businessAssG = new Associate(0, "Davoda", LocalDate.now(), telia, "Skurk", new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));
        Associate businessAssH = new Associate(0, "Davoda", LocalDate.now(), telia, "Skurk", new ContactInfo("skurk@skurk.com", "Skrukgatan", "123"));

        ArrayList<Associate> tempEmployeee = new ArrayList<Associate>();
        tempEmployeee.add(associateA);
        tempEmployeee.add(associateB);
        tempEmployeee.add(businessAssA);
        tempEmployeee.add(businessAssD);
        tempEmployeee.add(businessAssD);
        tempEmployeee.add(businessAssD);
        tempEmployeee.add(associateG);
        tempEmployeee.add(associateH);

        LocalDateTime startDate = LocalDateTime.of(2015,10,10,10,10);
        LocalDateTime endDate = LocalDateTime.of(2015,12,10,10,10);
        LocalDateTime testDate = LocalDateTime.of(2015,9,10,10,10);

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

        int choice;
        switch (input) {
            case 1:
                Associate tempEmployee = objectManage.getPersonManage().createEmployee(myCompany, objectManage,
                        stringScanner);
                myCompany.addEmployee(tempEmployee);
                break;
            case 2:
                Associate tempBusinessAssociate = objectManage.getPersonManage().createBusinessAssociate(myCompany,
                        objectManage, stringScanner, intScanner);
                myCompany.addBusinessAssociate(tempBusinessAssociate);
                break;
            case 3:
                Meeting tempMeeting = objectManage.getMeetingManage().createMeeting(myCompany, objectManage, stringScanner,
                        intScanner);
                if (myCompany.getMeetings() == null) {
                    myCompany.createMeetings();
                }

                myCompany.getMeetings().add(tempMeeting);
                break;
            case 4:
                choice = removeOrView();
                if (choice == 1) {
                    removeEmployee(myCompany);
                } else {
                    editAndViewEmployee(input, myCompany);
                }
                break;
            case 5:
                choice = removeOrView();
                if (choice == 1) {
                    removeBusinessAssociate(myCompany);
                } else {
                    editAndViewBusinessAssociation(input, myCompany);
                }
                break;
            case 6:
                choice = removeOrView();
                if (choice == 1) {
                    // TODO här skall ett möte tas bort
                    System.out.println("Här ska vi koda hur ett möte tas bort");
                    break;
                }
                if (choice == 2) {
                    editAndViewMeeting(myCompany);
                    break;
                }
                if (choice == 3) {
                    mainMenu(myCompany);
                    break;
                }
                break;
            case 7:
                System.out.println("Saving and logging off");
                break;
            default:
                System.out.println("Wrong choice! Please try again!");
                break;
        }
    }

    public void subMenuEmployeeSwitch(int input, MyCompany myCompany, Associate currentPerson) {
        switch (input) {
            case 1:
                System.out.print("Set new name: ");
                String name = stringScanner.nextLine();
                currentPerson.setName(name);
                break;
            case 2:
                LocalDate birthDate = objectManage.getPersonManage().setBirthDate();
                currentPerson.setBirthDate(birthDate);
                break;
            case 3:
                System.out.print("Set new address: ");
                String address = stringScanner.nextLine();
                currentPerson.getContactInfo().setAddress(address);
                break;
            case 4:
                System.out.print("Set new email: ");
                String email = stringScanner.nextLine();
                email = objectManage.getContactInfoManage().setEmail(email, stringScanner);
                currentPerson.getContactInfo().setEmail(email);
                break;
            case 5:
                System.out.print("Set new phone number: ");
                String phoneNumber = stringScanner.nextLine();
                currentPerson.getContactInfo().setPhoneNumber(phoneNumber);

                break;
            case 6:
                System.out.println("Edit familymembers");
//                addOrViewFamily(currentPerson);
                break;
            case 7:
                System.out.println("Edit position");
                String position = stringScanner.nextLine();
                currentPerson.setPosition(position);
                break;
            case 8:
                mainMenu(myCompany);
                break;
            default:
                System.out.println("Wrong choice! Please try again!");
                break;
        }
    }

    public void subMenuBusinessSwitch(int input, MyCompany myCompany) {
        switch (input) {
            case 1:
                System.out.println("testar case 1");
                break;
            case 2:
                System.out.println("testar case 2");
                break;
            case 3:
                System.out.println("testar case 3");
                break;
            case 4:
                System.out.println("testar case 4");
                break;
            case 5:
                System.out.println("testar case 5");
                break;
            case 6:
                System.out.println("testar case 6");
                break;
            case 7:
                mainMenu(myCompany);
                break;
            default:
                System.out.println("Wrong choice! Please try again!");
                break;
        }
    }

    public void subMenuMeetingSwitch(int input, MyCompany myCompany) {
        switch (input) {
            case 1:
                System.out.println("testar case 1");
                break;
            case 2:
                System.out.println("testar case 2");
                break;
            case 3:
                System.out.println("testar case 3");
                break;
            case 4:
                System.out.println("testar case 4");
                break;
            case 5:
                System.out.println("testar case 5");
                break;
            case 6:
                System.out.println("testar case 6");
                break;
            case 7:
                mainMenu(myCompany);
                break;
            default:
                System.out.println("Wrong choice! Please try again!");
                break;
        }
    }

    public void editAndViewEmployee(int choice, MyCompany myCompany) {
        if (myCompany.getEmployees() == null) {
            System.out.println("You dont have any employees yet");
            System.out.println("Press any key to continue...");
            stringScanner.nextLine();
        } else {
            printManage.getPrintPerson().printPersonList(myCompany.getEmployees());
            System.out.print("Please choose employee: ");
            choice = menu.getInput(intScanner)-1;
            subMenuEmployee(choice, myCompany);
        }
    }

    public void editAndViewBusinessAssociation(int choice, MyCompany myCompany) {

        if (myCompany.getBusinessAssociates() == null) {
            System.out.println("You dont have any business associets yet");
            System.out.println("Press any key to continue...");
            stringScanner.nextLine();
        } else {
            printManage.getPrintPerson().printPersonList(myCompany.getBusinessAssociates());
            System.out.print("Please choose business associate: ");
            choice = menu.getInput(intScanner)-1;
            subMenuBusinessAssociate(choice, myCompany);
        }
        // TODO magic
    }

    public void editAndViewMeeting(MyCompany myCompany) {
        if (myCompany.getMeetings() == null) {
            System.out.println("You dont have any meetings yet");
            System.out.println("Press any key to continue...");
            stringScanner.nextLine();
        } else {
            printManage.getPrintMeeting().printMeetingList(myCompany.getMeetings());
            System.out.print("Choose meeting: ");
            input = menu.getInput(intScanner) - 1;
            Meeting currentMeeting = myCompany.getMeetings().get(input);
            printManage.getPrintMeeting().printInfo(currentMeeting);
            System.out.print("Do you want to create a journal? (1)Yes/(2)No: ");
            input = menu.getInput(intScanner);
            if (input != 1 && input != 2) {
                System.out.println("Wrong choice. Try again.");
            }
            if (input == 1) {
                ArrayList<String> protocol = createProtocol();
                Journal tempJournal = new Journal(protocol);
                currentMeeting.setJournal(tempJournal);
            }
        }
    }

    public ArrayList<String> createProtocol() {
        ArrayList<String> protocol = new ArrayList<String>();
        int itemCounter = 1;
        boolean addMore = true;
        do {
            System.out.println("Type item number " + itemCounter + " :");
            protocol.add(stringScanner.nextLine());
            boolean wrongInput = false;
            do {
                System.out.print("Do you want to type another item? [1]Yes/[2]No: ");
                int choice = menu.getInput(intScanner);

                if (choice == 1) {
                    itemCounter++;
                    wrongInput = false;
                } else if (choice == 2) {
                    addMore = false;
                    wrongInput = false;
                } else if (choice != 1 || choice != 2) {
                    wrongInput = true;
                    System.out.println("Wrong input. Try again!");
                }
            } while (wrongInput);

        } while (addMore);

        return protocol;
    }

    public void removeEmployee(MyCompany myCompany) {
        if (myCompany.getEmployees() == null) {
            System.out.println("You dont have any employees yet");
            System.out.println("Press any key to continue...");
            stringScanner.nextLine();
        } else {
            System.out.println("Employee removed");
        }
    }

    public void removeBusinessAssociate(MyCompany myCompany) {
        if (myCompany.getBusinessAssociates() == null) {
            System.out.println("You dont have any business associates yet");
            System.out.println("Press any key to continue...");
            stringScanner.nextLine();
        } else {
            System.out.println("Business associate removed");
        }
    }

    public int removeOrView() {
        boolean wrongChoice = false;
        do {
            System.out.println("1. Remove");
            System.out.println("2. Edit and View");
            System.out.println("3. Go Back");
            System.out.print("Choose option: ");
            input = menu.getInput(intScanner);
            if (input < 1 && input > 3) {
                System.out.println("Wrong choice. Try again.");
                wrongChoice = true;
            }
        } while (wrongChoice);
        return input;
    }

 /*   public void addOrViewFamily(Associate currentPerson) {
        boolean failedInput = true;

        if (currentPerson.getFamilyMembers() == null) {
            FamilyMember family = new FamilyMember();
        }
        do {
            System.out.println("1. Add companion");
            System.out.println("2. Add child");
            System.out.println("3. Edit and View");
            System.out.print("Choose option: ");
            input = menu.getInput(intScanner);

            if (input == 1) {
                System.out.print("Enter name: ");
                String name = stringScanner.nextLine();
                LocalDate birthDate = objectManage.getPersonManage().setBirthDate();

                FamilyMember companion = new FamilyMember(1, name, birthDate);

                currentPerson.getFamilyMembers().add(companion);

                failedInput = false;
            } else if (input == 2) {
                System.out.print("Enter name: ");
                String name = stringScanner.nextLine();
                LocalDate birthDate = objectManage.getPersonManage().setBirthDate();

                if (currentPerson.getFamily().getChildren() == null) {
                    currentPerson.getFamily().createChildrenArray();
                }

                Person child = new Person(2, name, birthDate);
                currentPerson.getFamily().addChild(child);

                failedInput = false;
            } else if (input == 3) {

                failedInput = false;
            } else {

                System.out.println("Wrong input, try again.");

            }
        } while (failedInput);
    }*/
}