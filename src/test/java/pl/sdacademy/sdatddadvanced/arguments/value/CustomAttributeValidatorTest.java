package pl.sdacademy.sdatddadvanced.arguments.value;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CustomAttributeValidatorTest {

    private final CustomAttributeValidator validator = new CustomAttributeValidator();

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {" ", "NOT_ATTR_"})
    void attributeNameShouldBeInvalid(String attributeName) {
        //given
        // puste - bo argument przychodzi ze źródła danych

        //when
        boolean isValid = validator.isNameValid(attributeName);

        //then
        Assertions.assertThat(isValid).isFalse();
    }

    @Test
    void attributeNameShouldBeValid() {
        String attributeName = "ATTR_KEY_1";

        boolean isValid = validator.isNameValid(attributeName);

        Assertions.assertThat(isValid).isTrue();
    }
}