package pl.sdacademy.sdatddadvanced.arguments.value;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;


class CustomAttributeValidatorTest {

    //shouldDoSthWhenInputInNull
    //shouldThrowWhenSthOccurs

    private final CustomAttributeValidator customAttributeValidator = new CustomAttributeValidator();

    //@EmptySource
    //@NullAndEmptySource
    @NullSource
    @ParameterizedTest
    @ValueSource(strings = {" ", "IncorrectStartingStr"})
    void shouldBeInvalidParameterName(String invalidName) {
        final boolean result = customAttributeValidator.isNameValid(invalidName);

        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,Michal",
            "2.1,Ala",
            "3,Andrzej"
    })
    void dummyTest(Double someNumber, String name) {

    }
}
