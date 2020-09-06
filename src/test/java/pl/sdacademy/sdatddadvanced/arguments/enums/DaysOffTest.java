package pl.sdacademy.sdatddadvanced.arguments.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class DaysOffTest {

  @EnumSource(value = DayOfWeek.class, names = {"SATURDAY", "SUNDAY"},
      mode = EnumSource.Mode.INCLUDE)
  @ParameterizedTest
  void shouldBeDayOff(final DayOfWeek day) {
    final boolean isOff = DaysOff.isDayOff(day);

    //then
    assertThat(isOff).isTrue();
  }

  @EnumSource(value = DayOfWeek.class, names = {"SATURDAY", "SUNDAY"},
      mode = EnumSource.Mode.EXCLUDE)
  @ParameterizedTest
  void shouldNotBeDayOff(final DayOfWeek day) {
    final boolean isOff = DaysOff.isDayOff(day);

    //then
    assertThat(isOff).isFalse();
  }

}