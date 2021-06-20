package pl.sdacademy.sdatddadvanced.arguments.arguments;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MedalsStatisticsProcessor {

  public List<String> getTopCountries(final List<MedalsStatistics> allMedalsStatistics, StatisticsType statisticsType) {
    return allMedalsStatistics.stream()
            .collect(Collectors.groupingBy(getGroupingFunction(statisticsType)))
            .entrySet().stream()
            .max(Comparator.comparingInt(Map.Entry::getKey)) // [10, [Polska, 10, 9, 8], [Litwa, 10, 2, 1]
            .map(entry -> entry.getValue().stream().map(MedalsStatistics::getCountry).collect(Collectors.toList()))
            .orElse(List.of());
  }

  private Function<MedalsStatistics, Integer> getGroupingFunction(StatisticsType statisticsType) {
    switch (statisticsType) {
      case MOST_GOLDS: return MedalsStatistics::getGolds;
      case MOST_SILVERS: return MedalsStatistics::getSilvers;
      case MOST_BRONZE: return MedalsStatistics::getBronze;
      case MOST_TOTAL: return medalsStatistics -> medalsStatistics.getGolds()
              + medalsStatistics.getSilvers() + medalsStatistics.getBronze();
    }
    throw new RuntimeException("Unknown statistics type");
  }

}
