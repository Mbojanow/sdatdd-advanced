package pl.sdacademy.sdatddadvanced.communicator;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@ToString(exclude = {"users"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Channel {
  private String name;
  private String topic;
  private List<User> users;
  private List<SlackMessage> slackMessages;
  private boolean isPrivate;

  public void sendMessage(final User user, final String messageText) {
    if (!users.contains(user)) {
      return;
    }

    final SlackMessage slackMessage = createMessage(messageText, user.getName());
    slackMessages.add(slackMessage);
    users.forEach(subscribedUser -> subscribedUser.handleNewMessage(name, slackMessage));
  }

  private SlackMessage createMessage(final String messageText, final String username) {
    return SlackMessage.builder()
        .username(username)
        .createdAt(LocalDateTime.now())
        .value(messageText)
        .build();
  }

  public void subscribe(final User user) {
    final boolean usernameNotSubscribed = users.stream()
        .noneMatch(subscribedUser -> subscribedUser.getName().equals(user.getName()));
    if (usernameNotSubscribed) {
      users.add(user);
    }
  }

  public List<String> getAllReadableMessages() {
    return slackMessages.stream()
        .map(SlackMessage::getReadable)
        .collect(Collectors.toList());
  }
}
