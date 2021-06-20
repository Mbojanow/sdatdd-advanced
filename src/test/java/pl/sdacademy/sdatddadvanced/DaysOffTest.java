package pl.sdacademy.sdatddadvanced;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.DayOfWeek;

import static org.assertj.core.api.Assertions.assertThat;

class DaysOffTest {

    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class, names = {"SATURDAY", "SUNDAY"}, mode = EnumSource.Mode.INCLUDE)
    void shouldBeDayOff(DayOfWeek dayOfWeek) {
        boolean dayOff = DaysOff.isDayOff(dayOfWeek);

        assertThat(dayOff).isTrue();
    }

    @ParameterizedTest
                                                                               // chce wszystkie inne wartosci niz te podane w names
    @EnumSource(value = DayOfWeek.class, names = {"SATURDAY", "SUNDAY"}, mode = EnumSource.Mode.EXCLUDE)
    //@EnumSource(value = DayOfWeek.class, names = {"MONDAY", "TUESDAY", "WEDNESDAY"}, mode = EnumSource.Mode.INCLUDE)
    void shouldNotBeDayOff(DayOfWeek dayOfWeek) {
        boolean dayOff = DaysOff.isDayOff(dayOfWeek);

        assertThat(dayOff).isFalse();
    }

    //tylko do eksperymentów
    @ParameterizedTest
    //test przyjmuje wartości: Imie, wiek (int), wzrost jako Double 1.52
    @CsvSource({
            "Ania,22,1.70",
            "Michal,32,1.81"
    })
    //@CsvFileSource(resources = "/data.txt")
    void dummyTest(String name, Integer age, Double height) {

    }

}