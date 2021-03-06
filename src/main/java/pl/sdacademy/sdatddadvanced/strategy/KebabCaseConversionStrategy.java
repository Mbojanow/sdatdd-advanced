package pl.sdacademy.sdatddadvanced.strategy;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.util.Objects.isNull;

// double checked
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KebabCaseConversionStrategy extends TextConversionStrategyTemplate {

  private static KebabCaseConversionStrategy instance;

  public static KebabCaseConversionStrategy getInstance() {
    if (isNull(instance)) {
      // ReadWriteLock, ReentrantLock, ReadLock, WriteLock
      synchronized (KebabCaseConversionStrategy.class) {
        if (isNull(instance)) {
          instance = new KebabCaseConversionStrategy();
        }
      }
    }
    return instance;
  }

  @Override
  protected boolean handleNonAlphanumericChar(final char c, final StringBuilder builder) {
    return true;
  }

  @Override
  protected boolean handleAlphanumericChar(final char c, final boolean shouldApplyActionBeforeNextWord, final StringBuilder builder) {
    if (shouldApplyActionBeforeNextWord) {
      builder.append('-');
    }
    builder.append(Character.toLowerCase(c));
    return false;
  }
}
