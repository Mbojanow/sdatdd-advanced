package pl.sdacademy.sdatddadvanced.arguments.arguments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class MedalsStatisticsProcessorTest {

  private MedalsStatisticsProcessor processor = new MedalsStatisticsProcessor();

  @ArgumentsSource(CountriesParametersProvider.class)
  @ParameterizedTest
  void shouldGetTopCountries(final List<MedalsStatistics> medals,
                             final StatisticsType statisticsType,
                             final List<String> expectedCountries) {
    final List<String> topCountries = processor.getTopCountries(medals, statisticsType);

    assertThat(topCountries).containsExactlyInAnyOrderElementsOf(expectedCountries);
  }

  static class CountriesParametersProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(final ExtensionContext extensionContext) throws Exception {
      return Stream.of(
          Arguments.of(List.of(
              MedalsStatistics.builder().golds(1).country("Poland").build(),
              MedalsStatistics.builder().golds(2).country("USA").build()
          ), StatisticsType.MOST_GOLDS, List.of("USA"))
          //Arguments.of(),
          //Arguments.of()
      );
    }
  }

}