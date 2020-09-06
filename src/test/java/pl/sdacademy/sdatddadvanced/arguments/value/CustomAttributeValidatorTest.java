package pl.sdacademy.sdatddadvanced.arguments.value;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CustomAttributeValidatorTest {

  private final CustomAttributeValidator validator = new CustomAttributeValidator();

  @ValueSource(strings = {"", " ", "\t"})
  @ParameterizedTest
  void shouldBeIncorrectCustomAttributeWhenKeyIncorrect(final String key) {
    // given
    final List<CustomAttribute> customAttributes = List.of(new CustomAttribute(key, "value"));

    //when
    final boolean isValid = validator.isValid(customAttributes);

    assertThat(isValid).isFalse();
  }

  @NullSource // valueSource ktore daje null
  @ParameterizedTest
  void shouldBeInvalidWhenValueIsNull(final String value) {
    // given
    final List<CustomAttribute> customAttributes =
        List.of(new CustomAttribute("key", value));

    //when
    final boolean isValid = validator.isValid(customAttributes);

    assertThat(isValid).isFalse();
  }

}