package pl.sdacademy.sdatddadvanced.exceptions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.sdacademy.sdatddadvanced.arguments.enums.AccessType;

import java.time.DayOfWeek;

public class asd {

  @ParameterizedTest
  @EnumSource(value = AccessType.class, names = { "READ", "WRITE" } ,mode = EnumSource.Mode.INCLUDE)
  void qwe(AccessType asd) {
  }

}
