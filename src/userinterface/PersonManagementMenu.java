package userinterface;

import companies.MyCompany;
import managers.ObjectManage;
import managers.PrintManage;
import persons.Associate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonManagementMenu {

    PrintManage printManage = new PrintManage();
    ObjectManage objectManage = new ObjectManage();
    Scanner stringScanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);

    Menu subMenu = new ConsoleMenu();
    ArrayList<String> personManagementMenuAlternatives;
    int userInputSubMenuChoice;

    public void personManagementMenu(int userInputPersonChoice, MyCompany myCompany, ArrayList<Associate> associate) {

        personManagementMenuAlternatives = new ArrayList<>();
        personManagementMenuAlternatives.add("Edit name");
        personManagementMenuAlternatives.add("Edit birth date");
        personManagementMenuAlternatives.add("Edit address");
        personManagementMenuAlternatives.add("Edit e-mail");
        personManagementMenuAlternatives.add("Edit phone number");
        personManagementMenuAlternatives.add("Edit position");
        personManagementMenuAlternatives.add("Add tags");
        personManagementMenuAlternatives.add("Create family member");
        personManagementMenuAlternatives.add("Add family note");
        personManagementMenuAlternatives.add("Remove this person");
        personManagementMenuAlternatives.add("Back to main menu");

        do {
            printManage.getPrintPerson().printInfo(associate.get(userInputPersonChoice));
            subMenu.setMenuTitle("---Edit and View---");
            subMenu.printMenu(personManagementMenuAlternatives);
            System.out.print("Choose option: ");
            userInputSubMenuChoice = subMenu.getInput(intScanner);
            personManagementSwitch(myCompany, userInputPersonChoice, userInputSubMenuChoice, associate);

            // To prevent index out of bounds when removing last person from last index.
            // Also to prevent selecting person replacing the index.
            if (userInputSubMenuChoice == personManagementMenuAlternatives.size() - 1) {
                userInputSubMenuChoice++;
            }

        } while (userInputSubMenuChoice != personManagementMenuAlternatives.size());

    }

    public void personManagementSwitch(MyCompany myCompany, int userInputPersonChoice, int userInputSubMenuChoice, ArrayList<Associate> associate) {
        switch (userInputSubMenuChoice) {
            case 1:
                System.out.print("Set new name: ");
                String name = stringScanner.nextLine();
                associate.get(userInputPersonChoice).setName(name);
                break;
            case 2:
                LocalDate birthDate = objectManage.getDateManage().getBirthDateFromUserInput();
                associate.get(userInputPersonChoice).setBirthDate(birthDate);
                break;
            case 3:
                System.out.print("Set new address: ");
                String address = stringScanner.nextLine();
                associate.get(userInputPersonChoice).getContactInfo().setAddress(address);
                break;
            case 4:
                System.out.print("Set new email: ");
                String email = stringScanner.nextLine();
                email = objectManage.getContactInfoManage().setEmail(email, stringScanner);
                associate.get(userInputPersonChoice).getContactInfo().setEmail(email);
                break;
            case 5:
                System.out.print("Set new phone number: ");
                String phoneNumber = stringScanner.nextLine();
                associate.get(userInputPersonChoice).getContactInfo().setPhoneNumber(phoneNumber);
                break;
            case 6:
                System.out.println("Edit position");
                String position = stringScanner.nextLine();
                associate.get(userInputPersonChoice).setPosition(position);
                break;
            case 7:
                    ArrayList<String> newTags = objectManage.getMeetingManage().createProtocol(stringScanner, intScanner);
                if(!objectManage.getErrorManage().catchArrayListNullPointerException(associate.get(userInputPersonChoice).getTags())) {
                    associate.get(userInputPersonChoice).getTags().addAll(newTags);
                } else {
                    associate.get(userInputPersonChoice).setTags(newTags);
                }

                // läggas till i den person vi jobbar med
                break;
            case 8:
                if (objectManage.getErrorManage().catchArrayListNullPointerException(associate.get(userInputPersonChoice).getFamilyMembers())) {
                    associate.get(userInputPersonChoice).setFamilyMembers(new ArrayList<>());
                }
                associate.get(userInputPersonChoice).getFamilyMembers().add(objectManage.getPersonManage().createFamilyMember(stringScanner));
                break;
            case 9:
                // add family note
                break;
            case 10:
                objectManage.getPersonManage().removePerson(myCompany, userInputPersonChoice, associate, intScanner);
                System.out.println("Press any key to continue...");
                stringScanner.nextLine();
                break;
            case 11:
                // This option takes you back to the main menu. Leave blank.
                break;
            default:
                System.out.println("Wrong choice! Please try again!");
                break;
        }
    }

}
