package calendar.event;

import java.io.Serializable;
import java.time.LocalTime;

public class Reminder implements Event, Serializable {

    private String typeOfEvent;
    private String nameOfEvent;
    private Integer dayOfEvent;
    private LocalTime beginHour;
    private LocalTime endHour;
    private String note;

    public Reminder(String typeOfEvent, String nameOfEvent, Integer dayOfEvent, LocalTime beginHour, LocalTime endHour, String note) {
        this.typeOfEvent = typeOfEvent;
        this.nameOfEvent = nameOfEvent;
        this.dayOfEvent = dayOfEvent;
        this.beginHour = beginHour;
        this.endHour = endHour;
        this.note = note;
    }

    @Override
    public String getDescription() {
        return nameOfEvent + note + beginHour + endHour;
    }

    @Override
    public String getEventType() {
        return typeOfEvent;
    }

    @Override
    public Integer getDay() {
        return dayOfEvent;
    }

    @Override
    public LocalTime getStartTime() {
        return beginHour;
    }

    @Override
    public LocalTime getEndTime() {
        return endHour;
    }

    @Override
    public String getName() {
        return nameOfEvent;
    }

    @Override
    public String toString() {
        if (note != null)
            return "\nType of event: " + getTypeOfEvent() + "\n" +
                    "Name of reminder: " + getNameOfEvent() + "\n" +
                    "Day of event: " + getDayOfEvent() + "\n" +
                    "Begin hour: " + getBeginHour() + "\n" +
                    "End hour: " + getEndHour() + "\n" +
                    "Event note: " + getNote();
        else
            return "\nType of event: " + getTypeOfEvent() + "\n" +
                    "Name of reminder: " + getNameOfEvent() + "\n" +
                    "Day of event: " + getDayOfEvent() + "\n" +
                    "Begin hour: " + getBeginHour() + "\n" +
                    "End hour: " + getEndHour();
    }

    public String getTypeOfEvent() {
        return typeOfEvent;
    }

    public void setTypeOfEvent(String typeOfEvent) {
        this.typeOfEvent = typeOfEvent;
    }

    public String getNameOfEvent() {
        return nameOfEvent;
    }

    public void setNameOfEvent(String nameOfEvent) {
        this.nameOfEvent = nameOfEvent;
    }

    public Integer getDayOfEvent() {
        return dayOfEvent;
    }

    public void setDayOfEvent(Integer dayOfEvent) {
        this.dayOfEvent = dayOfEvent;
    }

    public LocalTime getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(LocalTime beginHour) {
        this.beginHour = beginHour;
    }

    public LocalTime getEndHour() {
        return endHour;
    }

    public void setEndHour(LocalTime endHour) {
        this.endHour = endHour;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}