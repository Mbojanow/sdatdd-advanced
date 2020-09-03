package pl.sdacademy.sdatddadvanced.arguments.value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomAttribute {
  private String name;
  private String value;
}
