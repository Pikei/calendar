package calendar.dataCollector;

import calendar.event.Event;
import calendar.exceptions.BadInputException;
import java.time.LocalTime;
import java.util.Scanner;

public abstract class EventDataCollector {

    protected Scanner input = new Scanner(System.in).useDelimiter("\n");

    public abstract Event collectAndBuildEvent();

    public Integer dayOfMonth() {
        boolean exit = false;
        int day = 0;
        do {
            try {
                day = readDay();
                exit = true;
            } catch (BadInputException e) {
                e.incorrectDayMessage();
            }
        } while(!exit);
        return day;
    }

    public LocalTime beginHour() {
        int hour = 0, minute = 0;
        boolean exit = false;
        do {
            System.out.println("Enter the hour when event starts. (Pattern: \"hh:mm\")");
            System.out.print("Hour: ");
            String[] time = input.next().split(":");
            try {
                hour = validateHour(Integer.parseInt(time[0]));
                minute = validateMinute(Integer.parseInt(time[1]));
                exit = true;
            } catch (BadInputException e) {
                e.incorrectTimeMessage();
            }
        } while (!exit);

        return LocalTime.of(hour, minute);
    }

    public LocalTime endHour() {
        int hour = 0, minute = 0;
        boolean exit = false;
        do {
            System.out.println("Enter the hour when event ends. (Pattern: \"hh:mm\")");
            System.out.print("Hour: ");
            String[] time = input.next().split(":");
            try {
                hour = validateHour(Integer.parseInt(time[0]));
                minute = validateMinute(Integer.parseInt(time[1]));
                exit = true;
            } catch (BadInputException e) {
                e.incorrectTimeMessage();
            }
        } while (!exit);

        return LocalTime.of(hour, minute);
    }

    public String nameOfEvent() {
        System.out.println("Enter the name of event.");
        System.out.print("Name: ");
        return input.next();
    }

    public String note() {
        boolean exit;
        do {
            System.out.println("Do you want to add note? [y/n]");
            switch (input.next()) {
                case "y" -> {
                    System.out.print("Note: ");
                    return input.next();
                }
                case "n" -> {return null;}
                default -> {
                    System.out.println("Please enter correct option.");
                    exit = false;
                }
            }
        } while (!exit);
        return null;
    }

    private Integer readDay() throws BadInputException {
        System.out.println("Enter the day of month.");
        System.out.print("Day: ");
        int day = input.nextInt();
        if (day < 1 || day > 31) {
            throw new BadInputException();
        }
        else return day;
    }


    private Integer validateHour(int hour) throws BadInputException {
        if (hour < 0 || hour > 23) {
            throw new BadInputException();
        } else return hour;
    }

    private Integer validateMinute(int minute) throws BadInputException {
        if (minute < 0 || minute > 59) {
            throw new BadInputException();
        } else return minute;
    }
}