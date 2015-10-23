package entry;

import companies.MyCompany;
import contactInfo.ContactInfo;
import managers.ObjectManage;
import java.util.Scanner;

/**
 * Associate objects are stored in the company object.
 * Using the object manage to reach all manage options.
 */
public class Program {
    // TODO Skapa factory ist�llet (interface)

    Scanner reader = new Scanner (System.in);
    ObjectManage objectManage = new ObjectManage();
    String companyName = "Apple Computers Inc.";
    String email = "apple@apple.com";
    String streetAddress = "Pear Street";
    String phoneNumber = "A phone number";

    MyCompany myCompany = new MyCompany(companyName, new ContactInfo(email, streetAddress, phoneNumber));

    public void runProgram() {
        welcomeText();
        UserInterface userInterface = new UserInterface();
        userInterface.mainMenu(myCompany);

    }

    private void welcomeText() {
        System.out.println("\n\t*************************************************\t\t\n\t*"
                + "\t\t\t\t\t\t\t\t\t\t\t\t*\n\t*\t\t\tWELCOME to CRM Buddy 2.0\t\t\t*"
                + "\n\t*\t\t\t\t\t\t\t\t\t\t\t\t*\n\t************************************************"
                + "*\n\n\t\t\tPress ENTER to continue...");
        reader.nextLine();
    }

}