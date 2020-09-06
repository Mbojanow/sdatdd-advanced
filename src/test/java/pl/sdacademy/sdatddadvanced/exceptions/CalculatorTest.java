package pl.sdacademy.sdatddadvanced.exceptions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

  private Calculator calculator = new Calculator();

  @Test
  void shouldThrowWhenDividingByZero() {
    try {
      calculator.divide(1.0, 0.0);
      fail();
    } catch (DivisionByZeroException e) {
      assertThat(e.getMessage()).contains("zero");
    }
  }

}