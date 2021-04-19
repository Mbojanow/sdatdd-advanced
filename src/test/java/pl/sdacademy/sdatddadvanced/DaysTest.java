package pl.sdacademy.sdatddadvanced;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.DayOfWeek;

import static org.assertj.core.api.Assertions.assertThat;

class DaysTest {

    @EnumSource(value = DayOfWeek.class, names = {"SATURDAY", "SUNDAY"}, mode = EnumSource.Mode.INCLUDE)
    @ParameterizedTest
    void shouldBeDayOff(DayOfWeek dayOfWeek) {
        final boolean result = Days.isDayOff(dayOfWeek);

        assertThat(result).isTrue();
    }

    @EnumSource(value = DayOfWeek.class, names = {"SATURDAY", "SUNDAY"}, mode = EnumSource.Mode.EXCLUDE)
    @ParameterizedTest
    void shouldNotBeDayOff(DayOfWeek dayOfWeek) {
        final boolean result = Days.isDayOff(dayOfWeek);

        assertThat(result).isFalse();
    }

}
