package managers;

import printers.PrintCompany;
import printers.PrintMeeting;
import printers.PrintPerson;

/**
 * A placeholder for all print classes.
 */
public class PrintManage {

    PrintCompany printCompany = new PrintCompany();
    PrintMeeting printMeeting = new PrintMeeting();
    PrintPerson printPerson = new PrintPerson();

    public PrintCompany getPrintCompany() {
        return printCompany;
    }

    public PrintMeeting getPrintMeeting() {
        return printMeeting;
    }

    public PrintPerson getPrintPerson() {
        return printPerson;
    }

}