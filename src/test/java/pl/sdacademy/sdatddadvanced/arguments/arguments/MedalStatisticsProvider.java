package pl.sdacademy.sdatddadvanced.arguments.arguments;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.List;
import java.util.stream.Stream;

public class MedalStatisticsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                // zestaw argumentów do pierwszego testu
                Arguments.of(
                        List.of(
                                MedalsStatistics.builder().country("PL").golds(3).build(),
                                MedalsStatistics.builder().country("EN").golds(3).build(),
                                MedalsStatistics.builder().country("NE").golds(2).build()
                        ),
                        StatisticsType.MOST_GOLDS,
                        List.of("PL", "EN")
                ),
                // zestaw argumentów do drugiego testu
                Arguments.of(
                        List.of(
                                MedalsStatistics.builder().country("EN").silvers(3).build(),
                                MedalsStatistics.builder().country("NE").silvers(2).build()
                        ),
                        StatisticsType.MOST_SILVERS,
                        List.of("EN")
                )
        );
    }
}
