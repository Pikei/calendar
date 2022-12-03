package calendar;

import calendar.exceptions.BadInputException;

public class Main {
    public static void main(String[] args) throws BadInputException {
        var start = new MainMenu();
        start.run();
    }
}