package com.insightfullogic;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

// NB: this import:
import static java.time.temporal.TemporalAdjuster.*;

public class Threeten {

    public static void examples() {

        LocalDateTime timePoint = LocalDateTime.now();  // The current date and time
        LocalDate.of(2012, Month.DECEMBER, 12); // from values
        LocalDate.ofEpochDay(150);  // middle of 1970
        LocalTime.of(17, 18); // the train I took home today
        LocalTime.parse("10:15:30"); // From a String

        LocalDate theDate = timePoint.toLocalDate();
        Month month = timePoint.getMonth();
        int day = timePoint.getDayOfMonth();
        timePoint.getSecond();

        // Set the value, returning a new object
        LocalDateTime thePast = timePoint.withDayOfMonth(10).withYear(2010);

        // You can use direct manipulation methods, or pass a value and field pair
        LocalDateTime yetAnother = thePast.plusWeeks(3).plus(3, ChronoUnit.WEEKS);


        LocalDateTime foo, bar;

        foo = timePoint.with(lastDayOfMonth());
        bar = timePoint.with(previousOrSame(DayOfWeek.WEDNESDAY));

        // Using value classes as adjusters
        timePoint.with(LocalTime.now());

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        LocalTime truncatedTime = time.truncatedTo(ChronoUnit.SECONDS);

        // You can specify the zone id when creating a zoned date time
        ZoneId id = ZoneId.of("Europe/Paris");
        ZonedDateTime zoned = ZonedDateTime.of(timePoint, id);
        ZoneId value = ZoneId.from(zoned);
    }

}
