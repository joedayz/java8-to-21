package pe.joedayz.training.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CompararFechasYHoras {

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2023, 6, 1);
        LocalDate date2 = LocalDate.of(2023, 6, 3);

        if (date1.isBefore(date2)) {
            System.out.println(date1 + " es antes que " + date2);
        } else if (date1.isAfter(date2)) {
            System.out.println(date1 + " es después que " + date2);
        } else {
            System.out.println(date1 + " es igual a " + date2);
        }

        LocalTime time1 = LocalTime.of(14, 0);
        LocalTime time2 = LocalTime.of(16, 0);

        if (time1.isBefore(time2)) {
            System.out.println(time1 + " es antes que " + time2);
        } else if (time1.isAfter(time2)) {
            System.out.println(time1 + " es después que " + time2);
        } else {
            System.out.println(time1 + " es igual a " + time2);
        }

        LocalDateTime dateTime1 = LocalDateTime.of(2023, 6, 1, 14, 0);
        LocalDateTime dateTime2 = LocalDateTime.of(2023, 6, 1, 16, 0);

        if (dateTime1.isBefore(dateTime2)) {
            System.out.println(dateTime1 + " es antes que " + dateTime2);
        } else if (dateTime1.isAfter(dateTime2)) {
            System.out.println(dateTime1 + " es después que " + dateTime2);
        } else {
            System.out.println(dateTime1 + " es igual a " + dateTime2);
        }
    }
}
