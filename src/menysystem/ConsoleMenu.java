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
		System.out.print("Please choose an option: ");
		int i = intScanner.nextInt();
		return i;
	}
}