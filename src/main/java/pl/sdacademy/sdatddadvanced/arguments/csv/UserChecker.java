package pl.sdacademy.sdatddadvanced.arguments.csv;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.sdacademy.sdatddadvanced.arguments.enums.User;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@NoArgsConstructor
public class UserChecker {

  public boolean wasAdultAt(final User user, final LocalDate localDate) {
    final Long timestamp = user.getTimestamp();
    LocalDate birthDate = LocalDate.ofInstant(new Date(timestamp).toInstant(), ZoneId.systemDefault());
    return ChronoUnit.YEARS.between(birthDate, localDate) >= 18;
  }
}
