package pl.sdacademy.sdatddadvanced.arguments.csv;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import pl.sdacademy.sdatddadvanced.arguments.enums.User;

class UserCheckerTest {

  private UserChecker userChecker;

  @BeforeEach
  void setUp() {
    userChecker = new UserChecker();
  }

  @CsvSource({"Ala/2000-01-01,2018-01-01", "Andrzej/2000-01-01,2020-02-02",
  "Ula/1999-12-31,2018-01-01"})
  @ParameterizedTest
  void shouldBeAdult(@ConvertWith(UserConverter.class) final User user,
                     @ConvertWith(DateConverter.class) final LocalDate localDate) {
    final boolean isAdult = userChecker.wasAdultAt(user, localDate);

    assertThat(isAdult).isTrue();
  }
}