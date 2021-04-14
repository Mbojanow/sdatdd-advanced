package pl.sdacademy.sdatddadvanced.arguments.value;

import java.util.List;
import java.util.Objects;

public class CustomAttributeValidator {

  public boolean isValid(final List<CustomAttribute> customAttributes) {
    return customAttributes.stream()
        .filter(customAttribute -> !customAttribute.getName().isBlank())
        .filter(customAttribute -> Objects.nonNull(customAttribute.getValue()))
        .filter(customAttribute -> isNameValid(customAttribute.getName()))
        .distinct()
        .count() == customAttributes.size();
  }

  public boolean isNameValid(String attributeName) {
    return attributeName != null && !attributeName.isBlank() && attributeName.startsWith("ATTR_");
  }
}
