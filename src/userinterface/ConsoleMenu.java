package userinterface;

import managers.ObjectManage;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleMenu implements Menu {

    ObjectManage objectManage = new ObjectManage();
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
    }

    @Override
    public int getInput(Scanner intScanner) {
        return objectManage.getErrorManage().catchUserInputMismatchException(intScanner);
    }

}