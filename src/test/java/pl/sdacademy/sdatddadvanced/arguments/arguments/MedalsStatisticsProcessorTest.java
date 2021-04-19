package pl.sdacademy.sdatddadvanced.arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MedalsStatisticsProcessorTest {

    private final MedalsStatisticsProcessor processor = new MedalsStatisticsProcessor();

    @ArgumentsSource(MedalStatisticsProvider.class)
    @ParameterizedTest
    void shouldAggregateByStatisticType(List<MedalsStatistics> medalsStatistics, StatisticsType type,
                                        List<String> expectedCountries) {
        final List<String> result = processor.getTopCountries(medalsStatistics, type);

        assertThat(result).containsExactlyInAnyOrderElementsOf(expectedCountries);
    }
}
