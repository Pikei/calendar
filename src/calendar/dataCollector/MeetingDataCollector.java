package calendar.dataCollector;

import calendar.event.Event;
import calendar.event.Meeting;

import java.time.LocalTime;

import static calendar.event.EventType.MEETING;

public class MeetingDataCollector extends EventDataCollector {

    @Override
    public Event collectAndBuildEvent() {
        final String type = MEETING.getDisplayType();
        final String name = nameOfEvent();
        final int day = dayOfMonth();
        final LocalTime beginHour = beginHour();
        final LocalTime endHour = endHour();
        final String person = person();
        final String place = where();
        final String note = note();

        return new Meeting(type, name, day, beginHour, endHour, person, place, note);
    }

    private String where() {
        System.out.println("Where you want to meet?");
        return input.next();
    }

    public String person() {
        System.out.println("Enter the name of person you want to meet.");
        return input.next();
    }
}