package pl.sdacademy.sdatddadvanced.arguments.csv;

import java.time.LocalDate;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class DateConverter implements ArgumentConverter {
  @Override
  public Object convert(final Object o, final ParameterContext parameterContext) throws ArgumentConversionException {
    if (o instanceof String) {
      return LocalDate.parse((String)o);
    }
    throw new IllegalArgumentException("Cannot convert date from not a String");
  }
}
