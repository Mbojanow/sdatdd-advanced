package pl.sdacademy.sdatddadvanced.mocks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
  private Integer wheelsNum;
  private Integer doorsNum;
  private String model;
  private List<String> features;
}
