package pl.sdacademy.sdatddadvanced.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void shouldThrowWhenDividingByZero() {
        try {
            calculator.divide(2.0, 0.0);
            fail("Exception was expected but was not thrown");
        } catch (DivisionByZeroException exp) {
            // ok
        }
    }

}
