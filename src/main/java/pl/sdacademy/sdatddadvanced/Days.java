package pl.sdacademy.sdatddadvanced;

import java.time.DayOfWeek;

public class Days {

    public static boolean isDayOff(DayOfWeek dayOfWeek) {
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
}
