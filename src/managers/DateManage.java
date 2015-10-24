package managers;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Get user input and creates objects of LocalDate and LocalDateTime.
 * These objects are used in the creation of meetings and persons.
 */
public class DateManage {

    private int year, month, day, hour;
    private Scanner intScanner;
    private String wrongInput = "Wrong input. Please use correct format: ";

    public LocalDate getBirthDateFromUserInput() {
        System.out.println("Enter birth date.");
        LocalDate localDate;
        year = getYearFromUserInput();
        month = getMonthFromUserInput();
        while (true) {
            day = getDayFromUserInput();
            try {
                localDate = LocalDate.of(year, month, day);
                break;
            } catch (DateTimeException e) {
                String dateTimeExceptionErrorMessage = e.toString().substring(29);
                System.out.println(dateTimeExceptionErrorMessage);
            }
        }
        return localDate;
    }

    public LocalDateTime getPlannedMeetingTimeFromUserInput() {
        LocalDateTime localDateTime;
        year = getYearFromUserInput();
        month = getMonthFromUserInput();
        while (true) {
            day = getDayFromUserInput();
            if (hour == 0) {
                hour = getHourFromUserInput();
            }
            try {
                localDateTime = LocalDateTime.of(year, month, day, hour, 0);
                break;
            } catch (DateTimeException e) {
                String dateTimeExceptionErrorMessage = e.toString().substring(29);
                System.out.println(dateTimeExceptionErrorMessage);
            }
        }
        return localDateTime;
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
        System.out.print("Enter month (MM): ");
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
                System.out.print("Enter day (DD): ");
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

    private int getHourFromUserInput() {
        while (true) {
            try {
                System.out.print("Enter start hour (24h): ");
                intScanner = new Scanner(System.in);
                hour = intScanner.nextInt();
                while (hour < 0 || hour > 23) {
                    System.out.println(wrongInput);
                    hour = intScanner.nextInt();
                }
                return hour;
            } catch (Exception e) {
                System.out.println(wrongInput);
            }
        }
    }

}