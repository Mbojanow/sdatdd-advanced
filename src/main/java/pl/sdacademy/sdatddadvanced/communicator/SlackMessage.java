package pl.sdacademy.sdatddadvanced.communicator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SlackMessage {
  private String value;
  private LocalDateTime createdAt;
  private String username;

  public String getReadable() {
    final DateTimeFormatter dateTimeFormatter = DateTimeFormatter
        .ofPattern("dd-MM-yyyy hh:mm");
    return createdAt.format(dateTimeFormatter) + " " + username + "\n" + value;
  }
}
