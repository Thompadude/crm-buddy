package managers;

import companies.Meeting;
import companies.MyCompany;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchManage {

    public ArrayList<Meeting> searchProtocol(MyCompany myCompany, Scanner stringScanner) {
        String protocolItem;
        boolean searchHits = false;
        ArrayList<Meeting> meetingsContainingSearchedWord = new ArrayList<>();

        System.out.print("Type word to search for: ");
        String wordToSearchFor = stringScanner.nextLine();
        for (int i = 0; i < myCompany.getMeetings().size(); i++) {
            if (!(myCompany.getMeetings().get(i).getJournal() == null)) {
                for (int j = 0; j < myCompany.getMeetings().get(i).getJournal().getProtocol().size(); j++) {
                    protocolItem = myCompany.getMeetings().get(i).getJournal().getProtocol().get(j);
                    if (protocolItem.toLowerCase().contains(wordToSearchFor.toLowerCase())) {
                        meetingsContainingSearchedWord.add(myCompany.getMeetings().get(i));
                        searchHits = true;
                    }
                }
            }
        }
        if (!searchHits) {
            System.out.println("No search hits.");
        }
        return meetingsContainingSearchedWord;
    }

}
