package pl.sdacademy.sdatddadvanced.strategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

  @Captor
  private ArgumentCaptor<String> stringArgumentCaptor;

  @Mock
  private TextConversionStrategy textConversionStrategy;

  @Test
  void shouldProcess() {
    doNothing().when(customCommandLineParser).parse(any());
    when(customCommandLineParser.getFilePathArgValue()).thenReturn("filePath");
    when(customCommandLineParser.getConversionTypeArgValue()).thenReturn(ConversionType.KEBAB_CASE);
    when(fileContentProvider.readContent("filePath")).thenReturn("fileContent");
    when(conversionStrategyProvider.getStrategy(ConversionType.KEBAB_CASE))
        .thenReturn(textConversionStrategy);

    textProcessingFacade.process(new String[]{});

    verify(textConversionStrategy).modify(stringArgumentCaptor.capture());
    final String value = stringArgumentCaptor.getValue();
    assertThat(value).isEqualTo("fileContent");
  }

}