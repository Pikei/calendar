package calendar.filter;

import calendar.Calendar;
import calendar.MainMenu;
import calendar.event.EventType;

import java.util.Scanner;

public class EventSearchMenu {
    private final MainMenu menu = new MainMenu();
    private final Calendar event;
    private final Scanner input = new Scanner(System.in).useDelimiter("\n");

    public EventSearchMenu(Calendar event) {
        this.event = event;
    }

    public void searchMenu() {
        System.out.println("\nChoose by what you want to search: ");
        System.out.println("1. Type of event.");
        System.out.println("2. Day of event.");
        System.out.println("3. Key word.");
        System.out.println("4. Search by multiple conditions.");
        System.out.print("Your choice: ");
    }

    public void searchChoice() {
        boolean exit = false;
        do {
            searchMenu();
            switch (input.next()) {
                case "1" -> {
                    searchByTypeMenu();
                    exit = true;
                }
                case "2" -> {
                    System.out.print("Enter the day: ");
                    EventSearch search = new EventSearch(null, null, input.nextInt());
                    var sortedList = search.searchByDay(event.getAllEvents());
                    sortedList.forEach(System.out::println);
                    exit = true;
                }
                case "3" -> {
                    System.out.print("Enter key word: ");
                    EventSearch search = new EventSearch(null, input.next(), null);
                    var sortedList = search.searchByDescription(event.getAllEvents());
                    sortedList.forEach(System.out::println);
                    exit = true;
                }
                case "4" -> {
                    searchByMultipleConditions();
                    exit = true;
                }
                default -> System.out.println("Please enter correct option.\n");
            }
        } while (!exit);
    }

    public void searchByTypeMenu() {
        menu.availableTypes();
        System.out.print("Your choice: ");
        boolean exit;
        do {
            exit = true;
            switch (input.next()) {
                case "1" -> searchMeeting();
                case "2" -> searchPhoneCall();
                case "3" -> searchReminder();
                default -> {
                    System.out.println("Choose correct option.");
                    exit = false;
                }
            }
        } while (!exit);
    }

    public void searchMeeting() {
        EventSearch search = new EventSearch("Meeting", null, null);
        var listOfEvents = event.getAllEvents();
        var sortedList = search.searchByType(listOfEvents);
        sortedList.forEach(System.out::println);
    }

    public void searchPhoneCall() {
        EventSearch search = new EventSearch("Phone Call", null, null);
        var sortedList = search.searchByType(event.getAllEvents());
        sortedList.forEach(System.out::println);
    }

    public void searchReminder() {
        EventSearch search = new EventSearch("Reminder", null, null);
        var sortedList = search.searchByType(event.getAllEvents());
        sortedList.forEach(System.out::println);
    }

    public void searchByMultipleConditions() {
        String type = searchingType();
        Integer day = readDayToSearch();
        System.out.println("Enter key word.");
        System.out.println("If you want to skip this criteria press and press \"enter\".");
        System.out.print("Your choice: ");
        String description = input.next();

        EventSearch search = new EventSearch(type, description, day);
        var sortedList = search.searchByMultipleConditions(event.getAllEvents());
        sortedList.forEach(System.out::println);
    }

    private Integer readDayToSearch() {
        System.out.println("Enter day to search event.");
        System.out.println("If you want to skip this criteria press \"0\", and press \"enter\".");
        System.out.print("Your choice: ");
        int day = input.nextInt();
        if (day >= 1 && day <= 31) {
            return day;
        }
        return null;
    }

    private String searchingType() {
        menu.availableTypes();
        System.out.println("If you want to skip this criteria press \"0\", and press \"enter\".");
        System.out.print("Your choice: ");
        int choice = input.nextInt();
        if (choice <= EventType.values().length && choice > 0) {
            EventType[] types = EventType.values();
            return types[choice-1].getDisplayType();
        }
        return null;
    }
}