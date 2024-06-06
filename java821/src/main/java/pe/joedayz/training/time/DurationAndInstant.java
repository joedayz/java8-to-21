package pe.joedayz.training.time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public class DurationAndInstant {

    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println("Hora actual: " + now);


        Instant specificInstant = Instant.ofEpochSecond(1622547800);
        System.out.println("Instant específico: " + specificInstant);

        Instant start = Instant.now();

        // Simulación de un retraso
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);

        System.out.println("Duración: " + duration.toMillis() + " milisegundos");

        Duration duration2 = Duration.ofHours(5);
        System.out.println("Duración: " + duration2);

        Duration durationMinutes = Duration.ofMinutes(90);
        System.out.println("Duración en minutos: " + durationMinutes);

        LocalTime time = LocalTime.of(10, 0);
        Duration durationHour = Duration.ofHours(2);
        LocalTime newTime = time.plus(durationHour);
        System.out.println("Nueva hora: " + newTime);

        LocalTime earlierTime = time.minus(durationHour);
        System.out.println("Tiempo después de restar duración: " + earlierTime);

        Duration duration3 = Duration.ofHours(3);
        Duration halfDuration = duration3.dividedBy(2);

        System.out.println("Duracion original: " + duration3);
        System.out.println("Mitad de la duración: " + halfDuration);

        Duration durationOneDay = Duration.ofDays(1);

        long hours = durationOneDay.toHours();
        long minutes = durationOneDay.toMinutes();
        long seconds = durationOneDay.getSeconds();
        long millis = durationOneDay.toMillis();
        long nanos = durationOneDay.toNanos();

        System.out.println("Duración en horas: " + hours);
        System.out.println("Duración en minutos: " + minutes);
        System.out.println("Duración en segundos: " + seconds);
        System.out.println("Duración en milisegundos: " + millis);
        System.out.println("Duración en nanosegundos: " + nanos);

        //ZonedDateTime zonedDateTime = ZonedDateTime.now(); Tarea para el miercoles

    }
}
