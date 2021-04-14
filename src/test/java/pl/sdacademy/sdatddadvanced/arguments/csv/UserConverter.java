package pl.sdacademy.sdatddadvanced.arguments.csv;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import pl.sdacademy.sdatddadvanced.arguments.enums.User;

import java.time.LocalDate;
import java.time.ZoneId;

public class UserConverter implements ArgumentConverter {

  @Override
  public Object convert(final Object source, final ParameterContext context) throws ArgumentConversionException {
    if (source instanceof String) {
      final String data = (String)source;
      String[] splitData = data.split("/");
      if (splitData.length != 2) {
        throw new RuntimeException("Cannot convert");
      }
      LocalDate parsedDate = LocalDate.parse(splitData[1]);
      return User.builder()
          .firstName(splitData[0])
          .timestamp(parsedDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli())
          .build();
    }
    throw new RuntimeException("BOOM");
  }
}

