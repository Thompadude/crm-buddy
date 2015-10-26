package entry;

import FileManage.ReadFromFile;
import FileManage.SaveToFile;
import companies.MyCompany;
import contactInfo.ContactInfo;
import userinterface.MainMenu;

import java.util.Scanner;

/**
 * Our customer "MyCompany" is hard coded depending on who want to use the program.
 * All other objects are stored in the MyCompany object.
 */
public class Program {

    Scanner reader = new Scanner(System.in);
    String companyName = "Apple Computers Inc.";
    String email = "apple@apple.com";
    String streetAddress = "Pear Street";
    String phoneNumber = "A phone number";

    MyCompany myCompany;
    String filePath = "myCompany.dat";

    protected void runProgram() {
        //Load File
        ReadFromFile readFromFile = new ReadFromFile(filePath);
        myCompany = readFromFile.readCompany(myCompany);

        // If there's no company to load from file, create a new one with hard coded info..
        if (myCompany == null) {
            myCompany = new MyCompany(companyName, new ContactInfo(email, streetAddress, phoneNumber));
        }

        welcomeText();
        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenu(myCompany);

        //Save file
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