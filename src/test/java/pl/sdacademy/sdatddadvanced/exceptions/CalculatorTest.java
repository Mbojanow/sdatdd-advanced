package pl.sdacademy.sdatddadvanced.exceptions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    // junit5 style
    @Test
    void shouldThrowWhenDividingByZero() {
        DivisionByZeroException exp = assertThrows(DivisionByZeroException.class, () -> calculator.divide(1.0, 0.0));

        assertThat(exp.getMessage()).isEqualTo("Cannot divide by zero");
    }
}