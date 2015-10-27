package userinterface;

import java.util.ArrayList;
import java.util.Scanner;

public interface Menu {

	void setMenuTitle(String menuTitle);
	
	void printMenu(ArrayList<String> list);
}
