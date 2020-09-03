package pl.sdacademy.sdatddadvanced.exceptions;

public class Calculator {

  public Double divide(final Double a, final Double b) {
    if (b == 0D) {
      throw new DivisionByZeroException("Cannot divide by zero");
    }
    return a / b;
  }
}
