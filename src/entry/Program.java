package entry;

import FileManage.ReadFromFile;
import FileManage.SaveToFile;
import companies.MyCompany;
import contactInfo.ContactInfo;
import userinterface.MainMenu;

import java.util.Scanner;

/**
 * Out customer "MyCompany" is hard coded depending on who want to use the program.
 * All other objects are stored in the MyCompany object.
 */
public class Program {

    Scanner reader = new Scanner(System.in);
    String companyName = "Apple Computers Inc.";
    String email = "apple@apple.com";
    String streetAddress = "Pear Street";
    String phoneNumber = "A phone number";

    MyCompany myCompany = new MyCompany(companyName, new ContactInfo(email, streetAddress, phoneNumber));

    protected void runProgram() {
        //Load File
        ReadFromFile readFromFile = new ReadFromFile("D:/Java/IntelliJ/crm/myCompany.dat");
        myCompany = readFromFile.readCompany();


        welcomeText();
        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenu(myCompany);

        SaveToFile saveToFile = new SaveToFile(myCompany, "D:/Java/IntelliJ/crm/myCompany.dat");
        //TODO Save File
    }

    private void welcomeText() {
        System.out.println("\n\t*************************************************\t\t\n\t*"
                + "\t\t\t\t\t\t\t\t\t\t\t\t*\n\t*\t\t\tWELCOME to CRM Buddy 2.0\t\t\t*"
                + "\n\t*\t\t\t\t\t\t\t\t\t\t\t\t*\n\t************************************************"
                + "*\n\n\t\t\tPress ENTER to continue...");
        reader.nextLine();
    }

}