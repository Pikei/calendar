package calendar;

import calendar.dataCollector.*;
import calendar.event.EventType;
import calendar.filter.EventSearchMenu;
import calendar.util.Date;

import java.time.LocalDate;
import java.util.Scanner;

public class MainMenu {

    private final Scanner input = new Scanner(System.in).useDelimiter("\n");
    private final Calendar event = new Calendar();
    private final MeetingDataCollector meetingDataCollector = new MeetingDataCollector();
    private final PhoneCallDataCollector phoneCallDataCollector = new PhoneCallDataCollector();
    private final ReminderDataCollector reminderDataCollector = new ReminderDataCollector();

    public void run() {
        var date = new Date();
        int day = date.today();
        event.readFromFile();
        event.loadThreeEvents(day, 3);
        mainMenu();
    }

    public void mainMenu() {
        boolean exit;
        do {
            availableOptions();
            exit = false;
            switch (input.next()) {
                case "0" -> {
                    System.out.println("Goodbye!");
                    exit = true;
                }
                case "1" -> event.showList();
                case "2" -> eventChoice();
                case "3" -> event.removeEvent();
                case "4" -> new EventSearchMenu(event).searchChoice();
                case "5" -> {
                    System.out.print("Type how many events do you want to see: ");
                    event.loadThreeEvents(LocalDate.now().getDayOfMonth(), input.nextInt());
                }
                default -> System.out.println("Please enter correct option.");
            }
        } while (!exit);
    }

    public void availableOptions() {
        System.out.println("\nChoose what you want to do:");
        System.out.println("1. Show events.");
        System.out.println("2. Add new event.");
        System.out.println("3. Remove existing event.");
        System.out.println("4. Search for event.");
        System.out.println("5. Show closest events.");
        System.out.println("0. Exit program.");
        System.out.print("Your choice: ");
    }

    public void availableTypes() {
        System.out.println("\nChoose type of event: ");
        EventType[] types = EventType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ". " + types[i].getDisplayType());
        }
    }

    public void eventChoice() {
        boolean exit = false;
        do {
            availableTypes();
            System.out.print("Your choice: ");
            switch (input.next()) {
                case "1" -> {
                    chosenMeeting();
                    exit = true;
                }
                case "2" -> {
                    chosenPhoneCall();
                    exit = true;
                }
                case "3" -> {
                    chosenReminder();
                    exit = true;
                }
                default -> System.out.println("Please enter correct option.\n");
            }
        } while (!exit);
    }

    public void chosenMeeting() {
        event.addEvent(meetingDataCollector.collectAndBuildEvent());
    }

    public void chosenPhoneCall() {
        event.addEvent(phoneCallDataCollector.collectAndBuildEvent());
    }

    public void chosenReminder() {
        event.addEvent(reminderDataCollector.collectAndBuildEvent());
    }
}