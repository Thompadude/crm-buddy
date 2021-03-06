package userinterface;

import java.util.ArrayList;

public class ConsoleMenu implements Menu {

    protected String menuTitle;

    @Override
    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    @Override
    public void printMenu(ArrayList<String> list) {

        int i = 0;

        System.out.println("\t" + menuTitle);

        for (String line : list) {
            i++;
            System.out.println("\t" + i + ". " + line);
        }
    }

}