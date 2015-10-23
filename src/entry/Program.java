package entry;

import companies.MyCompany;
import contactInfo.ContactInfo;

import java.util.Scanner;

/**
 * Out customer "MyCompany" is hard coded depending on who want to use the program.
 * All other objects are stored in the MyCompany object.
 */
public class Program {
    // TODO Skapa factory ist�llet (interface)

    Scanner reader = new Scanner(System.in);
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