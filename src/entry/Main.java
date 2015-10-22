package entry;

import companies.MyCompany;
import contactInfo.ContactInfo;

public class Main {
    public static void main(String[] args) {

        String companyName = "Apple Computers Inc.";
        String email = "apple@apple.com";
        String streetAddress = "Pear Street";
        String phoneNumber = "Ett telenr";

        MyCompany myCompany = new MyCompany(companyName, new ContactInfo(email, streetAddress, phoneNumber));

        Program program = new Program();
        program.runProgram(myCompany);
    }

}