package pl.sdacademy.sdatddadvanced.strategy;

public enum NoOpConversionStrategy implements TextConversionStrategy {
  INSTANCE;

  @Override
  public String modify(final String textToModify) {
    return textToModify;
  }
}
