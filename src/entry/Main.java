package entry;

import companies.Company;
import persons.Associate;
import persons.ContactInfo;
import printers.PrintCompany;

public class Main {
    public static void main(String[] args) {
    	//Företag test
    	ContactInfo volvoInfo = new ContactInfo("bajs@hh.se", "hemma", "bajsNummer");
    	Company volvo = new Company("Volvo", volvoInfo);
    	
    	//Associate test
    	ContactInfo kalleKulaInfo = new ContactInfo("kallekulasmejl", "kallekulaAdress", "666444");
    	Associate kalleKula = new Associate(0, "Kalle Kula", null, volvo, "BigBoss", kalleKulaInfo);
    	
    	volvo.addEmployee(kalleKula);
    	
    	PrintCompany prntCmp = new PrintCompany();
    	
    	prntCmp.printName(volvo);
    	prntCmp.printContactInfo(volvo);
    	prntCmp.printEmployees(volvo);
    	
        // Meeting mote = new Meeting(null, null, null, null);
    }

}
