package pl.sdacademy.sdatddadvanced.arguments.enums;

import java.time.DayOfWeek;

public class DaysOff {

  public static boolean isDayOff(final DayOfWeek day) {
    return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
  }
}
