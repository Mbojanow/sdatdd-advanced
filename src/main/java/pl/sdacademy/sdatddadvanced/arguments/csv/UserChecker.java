package pl.sdacademy.sdatddadvanced.arguments.csv;

import lombok.NoArgsConstructor;
import pl.sdacademy.sdatddadvanced.arguments.enums.User;

import java.time.LocalDate;

@NoArgsConstructor
public class UserChecker {

  public boolean wasAdultAt(final User user, final LocalDate localDate) {
    return false;
  }
}
