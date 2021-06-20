package pl.sdacademy.sdatddadvanced;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class DaysOff {

    private static final Map<DayOfWeek, Boolean> DAYS_OF_WEEK_OFF = new HashMap<>();

    static {
        DAYS_OF_WEEK_OFF.put(DayOfWeek.MONDAY, false);
        DAYS_OF_WEEK_OFF.put(DayOfWeek.TUESDAY, false);
        DAYS_OF_WEEK_OFF.put(DayOfWeek.WEDNESDAY, false);
        DAYS_OF_WEEK_OFF.put(DayOfWeek.THURSDAY, false);
        DAYS_OF_WEEK_OFF.put(DayOfWeek.FRIDAY, false);
        DAYS_OF_WEEK_OFF.put(DayOfWeek.SATURDAY, true);
        DAYS_OF_WEEK_OFF.put(DayOfWeek.SUNDAY, true);
    }

    public static boolean isDayOff(DayOfWeek dayOfWeek) {
        return DAYS_OF_WEEK_OFF.get(dayOfWeek);
    }
}
