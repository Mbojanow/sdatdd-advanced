package pl.sdacademy.sdatddadvanced.arguments.arguments;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MedalsStatisticsProcessor {

  /*
  1. [Country -> ilosci złotych medali]

  [ (PL, 3), (NE, 2), (EN, 3) ] ->

  [ 3: [(PL, 3), (EN, 3)] ]
  [ 2: [(NE, 2)]

   */

  public List<String> getTopCountries(final List<MedalsStatistics> allMedalsStatistics, StatisticsType statisticsType) {
    return allMedalsStatistics.stream()
            .collect(Collectors.groupingBy(medalsStatistics -> medalsStatistics.getGolds())) // wybrać odpowiednią Function na podstawie statisticType
            .entrySet().stream()
            .max(Comparator.comparingInt(entry -> entry.getKey())) //[ 3: [(PL, 3), (EN, 3)] ]
            .map(entry -> entry.getValue().stream()
                    .map(x -> x.getCountry())
                    .collect(Collectors.toList()))
            .orElse(List.of());
  }

}
