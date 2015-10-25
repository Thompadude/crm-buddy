package managers;

import java.util.ArrayList;
import java.util.Scanner;

public class ErrorManage {

    //skriv javaDoc om denna boolean
    public <T> boolean catchArrayListNullPointerException(ArrayList<T> t) {
        if (t == null) {
            return true;
        }
        return false;
    }

    public int catchUserInputMismatchException(Scanner intScanner) {
        while (true) {
            try {
                intScanner = new Scanner(System.in);
                int input = intScanner.nextInt();
                return input;
            } catch (Exception ex) {
                System.out.print("Wrong input. You must enter a number: ");
            }
        }
    }

    // 0-based. -1 cause of UI.
    public <T> boolean catchArrayIndexOutOfBoundsException(ArrayList<T> t, int choice) {
        if (choice > t.size() - 1 || choice < 0) {
            System.out.println("Wrong choice. Try again.");
            return true;
        } else {
            return false;
        }
    }

}