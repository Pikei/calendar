package calendar.filter;

import calendar.event.Event;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EventSearch {

    private String eventType;
    private String description;
    private Integer day;

    private final Predicate<Event> equalsType = event -> event.getEventType().equals(eventType);
    private final Predicate<Event> equalsDay = event -> event.getDay().equals(day);
    private final Predicate<Event> containsDescription = event -> event.getDescription().contains(description);

    public EventSearch(String eventType, String description, Integer day) {
        this.eventType = eventType;
        this.description = description;
        this.day = day;
    }

    public List<Event> searchByMultipleConditions(HashMap<Integer, ArrayList<Event>> allEvents) {
        return allEvents.values().stream()
                .flatMap(ArrayList::stream)
                .filter(equalsDay.or(equalsType.or(containsDescription)))
                .collect(Collectors.toList());
    }
    public List<Event> searchByType(HashMap<Integer, ArrayList<Event>> allEvents) {
        return allEvents.values().stream()
                .flatMap(ArrayList::stream)
                .filter(equalsType)
                .collect(Collectors.toList());
    }
    public List<Event> searchByDay(HashMap<Integer, ArrayList<Event>> allEvents) {
        return allEvents.values().stream()
                .flatMap(ArrayList::stream)
                .filter(equalsDay)
                .collect(Collectors.toList());
    }
    public List<Event> searchByDescription(HashMap<Integer, ArrayList<Event>> allEvents) {
        return allEvents.values().stream()
                .flatMap(ArrayList::stream)
                .filter(containsDescription)
                .collect(Collectors.toList());
    }
}