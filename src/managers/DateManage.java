package managers;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class DateManage {

    int year, month, day;
    Scanner intScanner;
    String wrongInput = "Wrong input. Please use correct format: ";

    public LocalDate getBirthDateFromUserInput() {
        LocalDate localDate;
        year = getYearFromUserInput();
        month = getMonthFromUserInput();
        while (true) {
            day = getDayFromUserInput();
            try {
                localDate = LocalDate.of(year, month, day);
                break;
            } catch (DateTimeException e) {
                //TODO Fixa snygg substring till detta felmeddelande.
                System.out.println(e);
            }
        }
        return localDate;
    }

    private int getYearFromUserInput() {
        System.out.print("Enter year (YYYY): ");
        while (true) {
            try {
                intScanner = new Scanner(System.in);
                year = intScanner.nextInt();
                while (year < 1000 || year > 9999) {
                    System.out.print(wrongInput);
                    year = intScanner.nextInt();
                }
                break;
            } catch (Exception e) {
                System.out.print(wrongInput);
            }
        }
        return year;
    }

    private int getMonthFromUserInput() {
        System.out.print("Enter birth month (MM): ");
        while (true) {
            try {
                intScanner = new Scanner(System.in);
                month = intScanner.nextInt();
                while (month < 1 || month > 12) {
                    System.out.print(wrongInput);
                    month = intScanner.nextInt();
                }
                break;
            } catch (Exception e) {
                System.out.print(wrongInput);
            }
        }
        return month;
    }

    private int getDayFromUserInput() {
        while (true) {
            try {
                System.out.print("Enter birth day (DD): ");
                intScanner = new Scanner(System.in);
                day = intScanner.nextInt();
                while (day < 1 || day > 31) {
                    System.out.print(wrongInput);
                    day = intScanner.nextInt();
                }
                return day;
            } catch (Exception e) {
                System.out.print(wrongInput);
            }
        }
    }

}