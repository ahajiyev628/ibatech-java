package lesson7;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.chrono.IsoEra;

/**
 * + Weekdays: 7 : Mon, Tue, ... Sat, Sun
 * + season: 4 : Summer, Winter, Spring ,...
 * + months of year: 12 Jan...Dec
 * + directions: (2d: UP/DOWN/LEFT/RIGHT)
 * + compass directions: S, W, N, E
 *
 * - Planets: ??? : Sirius, Saturn, ...
 * - Cities
 * - Countries
 * +/- Time of day: AM, PM (evening morning etc )
 * - continents
 */


public class EnumSolution {

  DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
  Month month = LocalDate.now().getMonth();
  IsoEra era = LocalDate.now().getEra();

  public static void doSomething(Color color) {
    switch (color) {
      case Red:    //...
      case Yellow: //...
      case Green:  //...
    }
  }

  public static void main(String[] args) {
    doSomething(Color.Red);    // +
    doSomething(Color.Yellow);  // +
    doSomething(Color.Green); // +
    // that will not compile anymore
//    doSomething(YELLOW); // +/-
//    doSomething(blue);   // --
//    doSomething(Yelow);  // --
  }


}
