package entry;

import java.time.LocalDate;

import companies.MyCompany;
import companies.Meeting;
import persons.Associate;
import persons.ContactInfo;
import printers.PrintCompany;
import printers.PrintMeeting;

public class Main {
    public static void main(String[] args) {
    	//Företag test
    	ContactInfo volvoInfo = new ContactInfo("bajs@hh.se", "hemma", "bajsNummer");
    	MyCompany volvo = new MyCompany("Volvo", volvoInfo);
    	
    	//Associate test
    	ContactInfo kalleKulaInfo = new ContactInfo("kallekulasmejl", "kallekulaAdress", "666444");
    	Associate kalleKula = new Associate(0, "Kalle Kula", null, volvo, "BigBoss", kalleKulaInfo);
    	Associate kalleKula2 = new Associate(0, "Kalle Kula", null, volvo, "BigBoss", kalleKulaInfo);
    	Associate kalleKula3 = new Associate(0, "Kalle Kula", null, volvo, "BigBoss", kalleKulaInfo);
    	Associate kalleKula4 = new Associate(0, "Kalle Kula", null, volvo, "BigBoss", kalleKulaInfo);
    	
    	volvo.addEmployee(kalleKula);
    	
    	//PrintCompany prntCmp = new PrintCompany();
    	
    	//prntCmp.printInfo(volvo);
    	//prntCmp.printEmployees(volvo);
    	
         Meeting mote = new Meeting("Bögmötet", null, LocalDate.now(), LocalDate.now());
         mote.addParticipants(kalleKula);
         mote.addParticipants(kalleKula2);
         mote.addParticipants(kalleKula3);
         mote.addParticipants(kalleKula4);
         
         PrintMeeting print = new PrintMeeting();
         
         print.printInfo(mote);
    }

}
