package pl.sdacademy.sdatddadvanced.arguments.csv;

import lombok.NoArgsConstructor;
import pl.sdacademy.sdatddadvanced.arguments.enums.User;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@NoArgsConstructor
public class UserChecker {

  public boolean wasAdultAt(final User user, final LocalDate localDate) {
    final LocalDate birthDate = LocalDate
        .ofInstant(new Date(user.getTimestamp()).toInstant(), ZoneId.systemDefault());
    return ChronoUnit.YEARS.between(birthDate, localDate) >= 18;
  }
}
