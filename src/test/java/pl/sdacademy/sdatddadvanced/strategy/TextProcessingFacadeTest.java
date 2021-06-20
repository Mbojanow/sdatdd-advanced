package pl.sdacademy.sdatddadvanced.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TextProcessingFacadeTest {

    @Mock
    private CustomCommandLineParser customCommandLineParser;

    @Mock
    private FileContentProvider fileContentProvider;

    @Mock
    private ConversionStrategyProvider conversionStrategyProvider;

    @InjectMocks
    private TextProcessingFacade textProcessingFacade;

    /*
      public String process(final String[] args) {
    customCommandLineParser.parse(args);
    final String content = fileContentProvider
        .readContent(customCommandLineParser.getFilePathArgValue());
    final TextConversionStrategy conversionStrategy
        = conversionStrategyProvider
        .getStrategy(customCommandLineParser.getConversionTypeArgValue());
    return conversionStrategy.modify(content);
     */

    @Mock
    private TextConversionStrategy strategy;

    @Test
    void shouldProcess() {
        String [] args = {"1", "2", "3"};
        Mockito.doNothing().when(customCommandLineParser).parse(args);
        Mockito.when(customCommandLineParser.getFilePathArgValue()).thenReturn("path1");
        Mockito.when(fileContentProvider.readContent("path1")).thenReturn("content1");
        Mockito.when(customCommandLineParser.getConversionTypeArgValue()).thenReturn(ConversionType.CAMEL_CASE);
        Mockito.when(conversionStrategyProvider.getStrategy(ConversionType.CAMEL_CASE))
                .thenReturn(strategy);
        Mockito.when(strategy.modify("content1")).thenReturn("content2");

        String result = textProcessingFacade.process(args);

        assertThat(result).isEqualTo("content2");
    }
}