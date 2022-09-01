package lesson18.dt;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class DateTimeApp {

  /**
   * Date: Y + M + D
   * Time: H + M + S + MS + NS
   * TimeZone: GMT / GMT+2 / GMT+3 / GMT+4 (GMT+5)
   *
   * representing:
   * Date
   * Time
   * Date+Time
   * Date + TimeZone
   * Time + TimeZone
   * Date + Time + TimeZone
   *
   * parsing:
   * String => Date
   *
   * formatting:
   * DateTime => String
   *
   * if (d1 > d2) ...
   * if (datetime1 + 3h < datetime2) ...
   */

//  public Optional<LocalDate> parse(String raw) {
//    try {
//      return Optional.of(...)
//    } catch (Exception x) {
//      return Optional.empty();
//    }
//  }

  public static void main(String[] args) {
    // Date only
    LocalDate ld1 = LocalDate.of(2022, 1, 31);
    LocalDate ld2 = LocalDate.of(2022, Month.SEPTEMBER, 30); // java.time.DateTimeException: Invalid date 'SEPTEMBER 31'
//    LocalDate ld3 = LocalDate.of(2022, Month.FEBRUARY, 29); // Invalid date 'February 29' as '2022' is not a leap year
    LocalDate ld4 = LocalDate.of(2022, Month.FEBRUARY, 28);
    LocalDate ld5 = LocalDate.now();
    LocalDate ld6 = LocalDate.parse("2022-03-15");
    LocalDate ld7 = LocalDate.parse("2022-03-15", DateTimeFormatter.ISO_DATE);
    LocalDate ld8 = LocalDate.parse("2022/03/15", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    // Time only
    LocalTime lt1 = LocalTime.of(20, 27);
    LocalTime lt2 = LocalTime.now();
    LocalTime lt3 = LocalTime.parse("15:03");
    // Date + Time
//    LocalDateTime ldt1 = LocalDateTime.of(2022, Month.DECEMBER, 200, 15, 30); // Invalid value for DayOfMonth (valid values 1 - 28/31): 200
    LocalDateTime ldt1 = LocalDateTime.of(2022, Month.DECEMBER, 20, 15, 30); // Invalid value for DayOfMonth (valid values 1 - 28/31): 200
    LocalDateTime ldt2 = ld1.atTime(lt1);
    LocalDateTime ldt3 = lt1.atDate(ld2);
    LocalDateTime ldt4 = ld5.atStartOfDay();
    // TimeZone
    ZonedDateTime zdt1 = ldt1.atZone(ZoneOffset.ofHours(2));
    ZonedDateTime zdt2 = ldt1.atZone(ZoneOffset.UTC);
    ZonedDateTime zdt3 = ld5.atStartOfDay(ZoneOffset.ofHours(5));

    String f1 = ldt2.format(DateTimeFormatter.ISO_DATE_TIME);

    boolean b1 = ld4.isBefore(ld2);
    boolean b2 = ld4.isAfter(ld2);
    boolean b3 = ld4.isEqual(ld2);
    boolean b4 = ld4.isLeapYear();
    // Dates - Dates related
    ld1.plusDays(1);
    ld1.plusWeeks(1);
    ld1.plusYears(1);
    ld1.plusMonths(1);

    ld1.minusDays(1);
    ld1.minusMonths(1);
    ld1.minusWeeks(1);
    ld1.minusYears(1);
    // Times - Time related
    lt1.plusHours(505);
    lt1.plusMinutes(2);
    lt1.plusSeconds(2);
    lt1.plusNanos(2);
    // DateTime - Time + Date - related
    LocalDateTime ldt5 = ldt4.plusDays(1000).plusHours(50);

    Period p1 = Period.of(0, 3, 0);
    Period p2 = Period.between(ld1, ld2);

//    if (databate.date + 3weeks < now) // ok
  }

}
