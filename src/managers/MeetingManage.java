package managers;

import companies.Journal;
import companies.Meeting;
import companies.MyCompany;
import menysystem.ConsoleMenu;
import persons.Associate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MeetingManage {

	PrintManage printManage = new PrintManage();

	// ArrayList<Associate> participants is stored in UI
	public Meeting createMeeting(MyCompany myCompany, ObjectManage objManage, Scanner stringScanner,
			Scanner intScanner) {
		ArrayList<Associate> tempParticipants = new ArrayList<Associate>();

		System.out.print("Please enter the topic of the meeting: ");
		String topic = stringScanner.nextLine();

		System.out.println("Employees");
		printManage.getPrintPerson().printPersonList(myCompany.getEmployees());
		addParticipant(myCompany, intScanner, tempParticipants, myCompany.getEmployees());
		
		if (!objManage.nullManage.nullCheckArrayList(myCompany.getBusinessAssociates())) {
			System.out.println("Business associates");
			printManage.getPrintPerson().printPersonList(myCompany.getBusinessAssociates());
			addParticipant(myCompany, intScanner, tempParticipants, myCompany.getBusinessAssociates());
		} else {
			System.out.println("NOTE: No business associates available for this meeting.");
		}

		System.out.println("Please set the desired start time: ");
		LocalDateTime startDate = setDateTime(intScanner);

		System.out.println(startDate.toString());

		System.out.println("Please set the desired end time: ");
		LocalDateTime endDate = setDateTime(intScanner);

		// TODO magic f�r att l�gga till m�ten i varje deltagare

		return new Meeting(topic, tempParticipants, startDate, endDate);
	}

	protected void addParticipant(MyCompany myCompany, Scanner intScanner, ArrayList<Associate> tempParticipants,
			ArrayList<Associate> currentArrayList) {
		int input;
		boolean exitInput;
		do {
			System.out.print("Please add person (press 0 for exit): ");
			input = intScanner.nextInt() - 1;
			if (input < myCompany.getEmployees().size()) {
				tempParticipants.add(currentArrayList.get(input));
			} else {
				System.out.println("Person does not exists!");
			}
			System.out.print("Do you want to add another person? [1]yes/[2]no: ");
			input = intScanner.nextInt();
			if (input == 1) {
				exitInput = false;
			} else {
				exitInput = true;
			}
		} while (!exitInput);
	}

	protected void removeParticipant(Meeting meeting, String searchName) {
		for (int i = 0; i < meeting.getParticipants().size(); i++) {
			if (searchName.toLowerCase().equals(meeting.getParticipants().get(i).getName().toLowerCase())) {
				meeting.getParticipants().remove(i);
			}
		}
	}

	// TODO if-statements for journal rules
	protected void createJournal(Meeting meeting, ArrayList<String> protocol) {
		meeting.setJournal(new Journal(protocol));
	}
	
	public ArrayList<String> createProtocol(Scanner stringScanner, Scanner intScanner) {
		ArrayList<String> protocol = new ArrayList<String>();
		int itemCounter = 1;
		boolean addMore = true;
		do {
			System.out.println("Type item number " + itemCounter + " :");
			protocol.add(stringScanner.nextLine());
			boolean wrongInput = false;
			do {
				System.out.print("Do you want to type another item? [1]Yes/[2]No: ");
				ConsoleMenu consoleMenu = new ConsoleMenu();
				int choice = consoleMenu.getInput(intScanner);

				if (choice == 1) {
					itemCounter++;
					wrongInput = false;
				} else if (choice == 2) {
					addMore = false;
					wrongInput = false;
				} else if (choice != 1 || choice != 2) {
					wrongInput = true;
					System.out.println("Wrong input. Try again!");
				}
			} while (wrongInput);

		} while (addMore);

		return protocol;
	}

	protected LocalDateTime setDateTime(Scanner intScanner) {
		System.out.print("Enter year: ");
		int year = intScanner.nextInt();
		System.out.print("Enter month: ");
		int month = intScanner.nextInt();
		System.out.print("Enter day: ");
		int day = intScanner.nextInt();
		System.out.print("Enter start hour (24h): ");
		int hour = intScanner.nextInt();
		LocalDateTime tempTime = null;
		tempTime = tempTime.of(year, month, day, hour, 0);
		return tempTime;
	}

}