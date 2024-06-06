package pe.joedayz.training.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeSamples {

    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("Fecha y hora actual: " + now);

        ZonedDateTime nowInNewYork = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Fecha y hora actual en Nueva York: " + nowInNewYork);

        LocalDateTime localDateTime = LocalDateTime.of(2024, 6, 5, 21, 03);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Europe/Paris"));
        System.out.println("Fecha y hora en París: " + zonedDateTime);

        ZonedDateTime nowInParis = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        ZonedDateTime nowInLima = nowInParis.withZoneSameInstant(ZoneId.of("America/Lima"));
        System.out.println("Fecha y hora actual en París: " + nowInParis);
        System.out.println("Fecha y hora actual en Lima: " + nowInLima);

        ZonedDateTime nowInLima2 = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z z");
        String formattedDate = nowInLima2.format(formatter);
        System.out.println("Fecha y hora actual en Lima: " + formattedDate);
    }
}
