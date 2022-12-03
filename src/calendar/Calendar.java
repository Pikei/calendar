package calendar;

import calendar.event.Event;
import calendar.exceptions.BadInputException;

import java.io.*;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Predicate;

public class Calendar {

    public final HashMap<Integer, ArrayList<Event>> allEvents = new HashMap<>();
    private final Scanner input = new Scanner(System.in);
    private final Comparator<Event> sortEventsDay = new Comparator<>() {
        @Override
        public int compare(Event o1, Event o2) {
            return o1.getStartTime().compareTo(o2.getStartTime());
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    };
    private final Comparator<Event> sortAllEvents = new Comparator<>() {
        @Override
        public int compare(Event o1, Event o2) {
            return o1.getDay().compareTo(o2.getDay());
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    };

    public void showList() {
        if(isListEmpty()) {
            return;
        }
        allEvents
                .values()
                .stream()
                .flatMap(ArrayList::stream)
                .sorted(sortAllEvents)
                .forEach(System.out::println);
    }

    public void addEvent(Event event) {
        Integer day = event.getDay();
        if (!allEvents.containsKey(day)) {
            allEvents.put(day, new ArrayList<>());
        }
        allEvents.get(day).add(event);
        if (allEvents.get(day).size() > 1) {
            allEvents.get(day).sort(sortEventsDay);
        }
        writeToFile();
    }

    public void removeEvent() {
        if(isListEmpty())
            return;
        int day = validateDayToRemove();
        if (allEvents.containsKey(day)) {
            Integer event = checkForMultipleEvents(day);
            if (event != null) {
                allEvents.get(day).remove(allEvents.get(day).get(event));
            } else {
                allEvents.remove(day);
            }
            System.out.println("Event of day: " + day + " was successfully removed.");
        } else {
            System.out.println("There aren't any events planned for day " + day + ".");
        }
        writeToFile();
    }

    private Integer validateDayToRemove() {
        boolean exit = false;
        int day = 0;
        do {
            try {
                day = readDayToRemove();
                exit = true;
            } catch (BadInputException e) {
                e.incorrectDayMessage();
            }
        } while(!exit);
        return day;
    }

    private Integer readDayToRemove() throws BadInputException {
        System.out.print("Enter the day of month to remove event: ");
        int day = input.nextInt();
        if (day < 1 || day > 31) {
            throw new BadInputException();
        }
        else return day;
    }

    private Integer checkForMultipleEvents(Integer day) {
        if (allEvents.get(day).size() > 1) {
            System.out.println("Choose event tou want to remove: ");
            Event event;
            System.out.println("| 0. Delete all events of day : " + day + " |");
            for (int i = 0; i < allEvents.get(day).size(); i++) {
                event = allEvents.get(day).get(i);
                System.out.println("| " + (i+1) + ". Type: " + event.getEventType() + " | name: " + event.getName() +
                        " | time: " + event.getStartTime() + " - " + event.getEndTime() + " |");
            }
            System.out.print("Your choice: ");
            int choice = input.nextInt();
            if (choice != 0) {
                return choice-1;
            }
        }
        return null;
    }

    private boolean isListEmpty() {
        if (allEvents.values().isEmpty()) {
            System.out.println("There aren't any events added yet.");
            return true;
        }
        return false;
    }

    public void writeToFile() {
        try {
            ObjectOutputStream saveFile = new ObjectOutputStream(new FileOutputStream("eventsList.bin"));
            saveFile.writeObject(allEvents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try {
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("eventsList.bin"));
            try {
                allEvents.putAll((HashMap<Integer, ArrayList<Event>>) readFile.readObject());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadThreeEvents(Integer day, Integer quantity) {
        Predicate<Event> nearestEvents = event -> event.getDay() >= day && event.getStartTime().isAfter(LocalTime.now());
        allEvents.values().stream()
                .flatMap(ArrayList::stream)
                .filter(nearestEvents)
                .sorted(sortAllEvents)
                .limit(quantity)
                .forEach(System.out::println);
    }

    public HashMap<Integer, ArrayList<Event>> getAllEvents() {
        return allEvents;
    }
}