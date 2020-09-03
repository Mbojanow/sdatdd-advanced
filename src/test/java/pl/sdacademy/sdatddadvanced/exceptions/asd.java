package pl.sdacademy.sdatddadvanced.exceptions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.sdacademy.sdatddadvanced.arguments.enums.AccessType;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;

public class asd {

  @ParameterizedTest
  @EnumSource(value = AccessType.class, names = { "READ", "WRITE" } ,mode = EnumSource.Mode.INCLUDE)
  void qwe(AccessType asd) {
    new DateFormatter().setFormat(new SimpleDateFormat());
  }

}
