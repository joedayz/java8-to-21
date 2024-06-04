package org.example.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeExample {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.of(localDate, localTime);

        System.out.println("LocalDate: " + localDate);
        System.out.println("LocalTime: " + localTime);
        System.out.println("LocalDateTime: " + currentDateTime);

        LocalDate specificDate = LocalDate.of(2023, 6, 3);
        LocalTime specificTime = LocalTime.of(14, 30, 0);
        LocalDateTime specificDateTime = LocalDateTime.of(2023, 6, 3, 14, 30, 0);

        System.out.println("Specific Date: " + specificDate);
        System.out.println("Specific Time: " + specificTime);
        System.out.println("Specific DateTime: " + specificDateTime);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDate parsedDate = LocalDate.parse("2023-06-03", dateFormatter);
        LocalTime parsedTime = LocalTime.parse("14:30:00", timeFormatter);
        LocalDateTime parsedDateTime = LocalDateTime.parse("2023-06-03 14:30:00", dateTimeFormatter);

        System.out.println("Fecha parseada: " + parsedDate);
        System.out.println("Hora parseada: " + parsedTime);
        System.out.println("Fecha y hora parseada: " + parsedDateTime);

        //operaciones
        LocalDate today = LocalDate.now();
        LocalDate oneWeekLater = today.plusWeeks(1);
        LocalDate oneMonthEarlier = today.minusMonths(1);

        LocalTime now = LocalTime.now();
        LocalTime inTwoHours = now.plusHours(2);
        LocalTime tenMinutesEarlier = now.minusMinutes(10);

        LocalDateTime currentDateTime2 = LocalDateTime.now();
        LocalDateTime nextYear = currentDateTime2.plusYears(1);
        LocalDateTime lastWeek = currentDateTime2.minusWeeks(1);

        System.out.println("Fecha de hoy: " + today);
        System.out.println("Una semana después: " + oneWeekLater);
        System.out.println("Un mes antes: " + oneMonthEarlier);

        System.out.println("Hora actual: " + now);
        System.out.println("En dos horas: " + inTwoHours);
        System.out.println("Diez minutos antes: " + tenMinutesEarlier);

        System.out.println("Fecha y hora actual: " + currentDateTime2);
        System.out.println("El próximo año: " + nextYear);
        System.out.println("La semana pasada: " + lastWeek);

    }
}
