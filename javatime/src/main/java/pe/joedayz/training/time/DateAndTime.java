package pe.joedayz.training.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateAndTime {

  public static void main(String[] args) {
    //Previo a Java 8
    Date currentDate = new Date();

    //Java 8
    LocalDate localDate = LocalDate.now();

    LocalDate.of(2023, 01, 01);
    LocalDate.parse("2023-01-01");

    //Previo a Java 8 - 5 semanas en el futuro
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_YEAR, 35);

    //Java 8
    LocalDate fiveWeeksFromTime = localDate.plus(5, ChronoUnit.WEEKS);

  }
}
