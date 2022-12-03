package calendar.event;

import java.time.LocalTime;

public interface Event {
    String getDescription();

    String getEventType();

    Integer getDay();

    LocalTime getStartTime();

    LocalTime getEndTime();

    String getName();
}