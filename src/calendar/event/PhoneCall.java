package calendar.event;

import java.io.Serializable;
import java.time.LocalTime;

public class PhoneCall implements Event, Serializable {

    private String typeOfEvent;
    private String nameOfEvent;
    private Integer dayOfEvent;
    private LocalTime beginHour;
    private LocalTime endHour;
    private String nameOfInterlocutor;
    private String phoneNumber;
    private String note;

    public PhoneCall(String typeOfEvent, String nameOfEvent, Integer dayOfEvent, LocalTime beginHour, LocalTime endHour, String nameOfInterlocutor, String phoneNumber, String note) {
        this.typeOfEvent = typeOfEvent;
        this.nameOfEvent = nameOfEvent;
        this.dayOfEvent = dayOfEvent;
        this.beginHour = beginHour;
        this.endHour = endHour;
        this.nameOfInterlocutor = nameOfInterlocutor;
        this.phoneNumber = phoneNumber;
        this.note = note;
    }

    @Override
    public String getDescription() {
        return nameOfEvent + note + nameOfInterlocutor + phoneNumber + beginHour + endHour;
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
                    "Name of phone call: " + getNameOfEvent() + "\n" +
                    "Day of event: " + getDayOfEvent() + "\n" +
                    "Begin hour: " + getBeginHour() + "\n" +
                    "End hour: " + getEndHour() + "\n" +
                    "Name of interlocutor: " + getNameOfInterlocutor() + "\n" +
                    "Phone number: " + getPhoneNumber() + "\n" +
                    "Event note: " + getNote();
        else
            return "\nType of event: " + getTypeOfEvent() + "\n" +
                    "Name of phone call: " + getNameOfEvent() + "\n" +
                    "Day of event: " + getDayOfEvent() + "\n" +
                    "Begin hour: " + getBeginHour() + "\n" +
                    "End hour: " + getEndHour() + "\n" +
                    "Name of interlocutor: " + getNameOfInterlocutor() + "\n" +
                    "Phone number: " + getPhoneNumber();
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

    public String getNameOfInterlocutor() {
        return nameOfInterlocutor;
    }

    public void setNameOfInterlocutor(String nameOfInterlocutor) {
        this.nameOfInterlocutor = nameOfInterlocutor;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}