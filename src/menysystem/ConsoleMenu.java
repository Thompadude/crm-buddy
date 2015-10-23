package menysystem;

import java.util.*;

public class ConsoleMenu implements Menu {	
	protected String menuTitle;
	protected ArrayList<String> menuAlternatives = new ArrayList<String>();

	
	@Override
	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;	
	}
	
	@Override
	public void printMenu(ArrayList<String> list) {
		int i = 0;
		System.out.println(menuTitle);
		for (String line : list) {
			i++;
			System.out.println(i + ". " + line);
		}
		System.out.println(++i + ". Save & Quit system");
	}
	@Override
	public int getInput(Scanner intScanner) {
		int i = 0;
		System.out.print("Please choose an option: ");
		i = catchInputMismatchException(intScanner);
		return i;
	}
	
	// Denna metod ska flyttas någonstans
	public int catchInputMismatchException(Scanner intScanner) {
		while(true) {
			try {
				intScanner = new Scanner(System.in);
				int input = intScanner.nextInt();
				return input;
			} catch (Exception ex) {
				System.out.print("Wrong input. Enter a new number: ");
			}
		}
	}
}