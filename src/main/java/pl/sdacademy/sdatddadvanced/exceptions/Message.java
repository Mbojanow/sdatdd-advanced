package pl.sdacademy.sdatddadvanced.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
  private String emailFrom;
  private String emailTo;
  private String content;
}
