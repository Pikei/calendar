package calendar.util;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Date {
    public Integer today() {
        System.out.print("Welcome! Today is: ");
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println(currentDate.getDayOfWeek() + " " + formatter.format(currentDate));
        System.out.println("Three nearest events: ");
        return currentDate.getDayOfMonth();
    }
}