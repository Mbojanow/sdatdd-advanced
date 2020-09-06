package pl.sdacademy.sdatddadvanced.arguments.csv;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import pl.sdacademy.sdatddadvanced.arguments.enums.User;

public class UserConverter implements ArgumentConverter {
  @Override
  public Object convert(final Object o, final ParameterContext parameterContext) throws ArgumentConversionException {
    if (o instanceof String) {
      final String userString = (String) o;
      final String[] splitUserData = userString.split("/");
      if (splitUserData.length != 2) {
        throw new IllegalArgumentException("Unknown data for User conversion");
      }
      //2020-10-10
      User.builder()
          .timestamp(LocalDate.parse(splitUserData[1]).getLong(ChronoUnit.MILLIS))
          .firstName(splitUserData[0])
          .build();
    }
    throw new IllegalArgumentException("Cannot convert user");
  }
}
