package calendar.dataCollector;

import calendar.event.Event;
import calendar.event.PhoneCall;

import java.time.LocalTime;

import static calendar.event.EventType.PHONE_CALL;

public class PhoneCallDataCollector extends EventDataCollector {

    @Override
    public Event collectAndBuildEvent() {
        final String type = PHONE_CALL.getDisplayType();
        final String name = nameOfEvent();
        final int day = dayOfMonth();
        final LocalTime beginHour = beginHour();
        final LocalTime endHour = endHour();
        final String person = person();
        final String phoneNumber = phoneNumber();
        final String note = note();
        return new PhoneCall(type, name, day, beginHour, endHour, person, phoneNumber, note);
    }

    public String person() {
        System.out.println("Enter the name of interlocutor.");
        return input.next();
    }

    public String phoneNumber() {
        System.out.println("Enter the phone number.");
        long number = input.nextLong();
        String temp = String.valueOf(number);
        temp = temp.replaceFirst("(\\d{3})(\\d{3})(\\d{3})", "$1-$2-$3");
        return temp;
    }
}