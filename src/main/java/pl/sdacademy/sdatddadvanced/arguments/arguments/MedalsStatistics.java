package pl.sdacademy.sdatddadvanced.arguments.arguments;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedalsStatistics {
  private String country;
  private Integer golds;
  private Integer silvers;
  private Integer bronze;

}
