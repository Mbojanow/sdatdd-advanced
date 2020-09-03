package pl.sdacademy.sdatddadvanced.arguments.csv;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import pl.sdacademy.sdatddadvanced.arguments.enums.User;

import java.time.LocalDate;

class UserCheckerTest {

  private UserChecker userChecker = new UserChecker();


  @ParameterizedTest
  @CsvSource(value = "Andrzej/1980-10-10,2000-01-01")
  void shouldBeAdult(@ConvertWith(UserConverter.class) User user, @ConvertWith(SimpleDateConverter.class) LocalDate date) {
    userChecker.wasAdultAt(user, date);
  }
}