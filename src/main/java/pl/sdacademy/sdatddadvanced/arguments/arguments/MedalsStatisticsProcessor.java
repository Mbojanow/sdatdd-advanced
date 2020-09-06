package pl.sdacademy.sdatddadvanced.arguments.arguments;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MedalsStatisticsProcessor {

  public List<String> getTopCountries(final List<MedalsStatistics> allMedalsStatistics,
                                      StatisticsType statisticsType) {
    return allMedalsStatistics.stream()
        .collect(Collectors.groupingBy(MedalsStatistics::getGolds))
        .entrySet().stream()
        .max(Comparator.comparingInt(Map.Entry::getKey))
        .map(Map.Entry::getValue)
        .map(countries -> countries.stream()
            .map(MedalsStatistics::getCountry)
            .collect(Collectors.toList()))
        .orElse(List.of());
  }

  private Function<MedalsStatistics, Integer> getAggregator(final StatisticsType statisticsType) {
    switch (statisticsType) {
      case MOST_GOLDS:
        return MedalsStatistics::getGolds;
      case MOST_TOTAL:
        return medalsStatistics -> medalsStatistics.getSilvers()
            + medalsStatistics.getBronze() + medalsStatistics.getGolds();
      case MOST_BRONZE:
        return MedalsStatistics::getBronze;
      case MOST_SILVERS:
        return MedalsStatistics::getSilvers;
    }
    return null;
  }
}
