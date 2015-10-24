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
                System.out.print("Wrong input. Enter a new number: ");
            }
        }
    }

}
