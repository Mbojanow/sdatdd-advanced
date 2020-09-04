package pl.sdacademy.sdatddadvanced.strategy;

public class ConversionStrategyDemo {
  //-t=KEBAB_CASE -f=/Users/michalbojanowski/work/spam/sdaprogtwo/src/main/resources/sometext  public static void main(String[] args) {
  public static void main(String[] args) {
    final CustomCommandLineParser parser = new CustomCommandLineParser();
    final FileContentProvider fileContentProvider = new FileContentProvider();
    final ConversionStrategyProvider strategyProvider = new ConversionStrategyProvider();

    final TextProcessingFacade facade = new TextProcessingFacade(
        parser, fileContentProvider, strategyProvider);
    facade.process(args);
  }
}
