package entry;

import saveload.ReadFromFile;
import saveload.SaveToFile;
import companies.MyCompany;
import contactInfo.ContactInfo;
import userinterface.MainMenu;

import java.util.Scanner;

/**
 * Our customer "MyCompany" is hard coded depending on who want to use the program.
 * All objects are stored in the MyCompany object.
 */
public class Program {

    Scanner reader = new Scanner(System.in);
    String companyName = "APPLE";
    String email = "info@apple.com";
    String streetAddress = "Banana Lane 65, LA";
    String phoneNumber = "+1 555-PINEAPPLE";

    MyCompany myCompany;
    String filePath = "myCompany.dat";

    protected void runProgram() {
        ReadFromFile readFromFile = new ReadFromFile(filePath);
        myCompany = readFromFile.readCompany(myCompany);

        // If there's no company to load from file, this creates a new one with hard coded info..
        if (myCompany == null) {
            myCompany = new MyCompany(companyName, new ContactInfo(email, streetAddress, phoneNumber));
        }

        welcomeText();

        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenu(myCompany);

        SaveToFile saveToFile = new SaveToFile(myCompany, filePath);
    }

    private void welcomeText() {
        System.out.println("\n\t* * * * * * * * * * * * * * * * * * * * *");
        System.out.println("\t*" + "\t\t\t\t\t\t\t\t\t\t*");
        System.out.println("\t*\t\tWELCOME to CRM Buddy v3.0\t\t*");
        System.out.println("\t*" + "\t\t\t\t\t\t\t\t\t\t*");
        System.out.println("\t* * * * * * * * * * * * * * * * * * * * *");
        System.out.println("\n\tPress ENTER to continue...");
        reader.nextLine();
    }

}