package pl.sdacademy.sdatddadvanced.exceptions;

import java.util.List;
import java.util.Objects;

public class CustomAttributeValidator {

  public boolean isValid(final List<CustomAttribute> customAttributes) {
    return customAttributes.stream()
        .filter(customAttribute -> !customAttribute.getName().isBlank())
        .filter(customAttribute -> Objects.nonNull(customAttribute.getValue()))
        .distinct()
        .count() == customAttributes.size();
  }
}
