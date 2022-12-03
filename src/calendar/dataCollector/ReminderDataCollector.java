package calendar.dataCollector;

import calendar.event.Event;
import calendar.event.Reminder;

import java.time.LocalTime;

import static calendar.event.EventType.REMINDER;

public class ReminderDataCollector extends EventDataCollector {

    @Override
    public Event collectAndBuildEvent() {
        final String type = REMINDER.getDisplayType();
        final String name = nameOfEvent();
        final Integer day = dayOfMonth();
        final LocalTime beginHour = beginHour();
        final LocalTime endHour = endHour();
        final String note = note();
        return new Reminder(type, name, day, beginHour, endHour, note);
    }
}