package pl.sdacademy.sdatddadvanced.arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MedalsStatisticsProcessorTest {

    private final MedalsStatisticsProcessor processor = new MedalsStatisticsProcessor();

    @ParameterizedTest
    @MethodSource("getSourceForStatisticsCalculation")
    void shouldCalculateStatistics(List<MedalsStatistics> medalsStatistics,
                                   StatisticsType statisticsType,
                                   List<String> expectedCountries) {
        List<String> topCountries = processor.getTopCountries(medalsStatistics, statisticsType);

        assertThat(topCountries).containsExactlyInAnyOrderElementsOf(expectedCountries);
    }

    static Stream<Arguments> getSourceForStatisticsCalculation() {
        return Stream.of(
                Arguments.of(
                        List.of(MedalsStatistics.builder()
                                        .country("Poland")
                                        .golds(5)
                                        .silvers(3)
                                        .bronze(0)
                                        .build(),
                                MedalsStatistics.builder()
                                        .country("France")
                                        .golds(7)
                                        .silvers(3)
                                        .bronze(0)
                                        .build()),
                        StatisticsType.MOST_GOLDS,
                        List.of("France")
                ),
                Arguments.of(
                        List.of(MedalsStatistics.builder()
                                        .country("Poland")
                                        .golds(5)
                                        .silvers(3)
                                        .bronze(0)
                                        .build(),
                                MedalsStatistics.builder()
                                        .country("France")
                                        .golds(7)
                                        .silvers(3)
                                        .bronze(0)
                                        .build()),
                        StatisticsType.MOST_SILVERS,
                        List.of("Poland", "France")
                )
        );
    }
}