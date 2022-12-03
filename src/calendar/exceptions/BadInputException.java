package calendar.exceptions;

public class BadInputException extends Exception {
    public void incorrectDayMessage() {
        System.out.println("Day must be between 1 and 31.");
        System.out.println();
    }

    public void incorrectTimeMessage() {
        System.out.println("Incorrect value!");
        System.out.println("Hour must be between 0 and 24.");
        System.out.println("Minute must be between 0 and 59.");
        System.out.println();
    }
}