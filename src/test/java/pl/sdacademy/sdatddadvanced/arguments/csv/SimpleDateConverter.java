package pl.sdacademy.sdatddadvanced.arguments.csv;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.time.LocalDate;

public class SimpleDateConverter implements ArgumentConverter {

  @Override
  public Object convert(final Object source, final ParameterContext context) throws ArgumentConversionException {
    if (source instanceof String) {
      return LocalDate.parse((String)source);
    }
    throw new RuntimeException("BOOM");
  }
}
