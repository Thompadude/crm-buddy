package managers;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles possible crashes caused by null pointers, index out of bounds etc.
 */
public class ErrorManage {

    /**
     * @return true if array list is null, else false
     */
    public <T> boolean catchArrayListNullPointerException(ArrayList<T> t) {
        if (t == null) {
            return true;
        }
        return false;
    }

    /**
     * Forces user to input an int
     */
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

    /**
     * @param choice User's choice in a menu.
     * @return true if user choose an out of bounds index in an array list, else false
     */
    public <T> boolean catchArrayIndexOutOfBoundsException(ArrayList<T> t, int choice) {
        if (choice > t.size() - 1 || choice < 0) {
            System.out.println("Wrong choice. Try again.");
            return true;
        } else {
            return false;
        }
    }

}