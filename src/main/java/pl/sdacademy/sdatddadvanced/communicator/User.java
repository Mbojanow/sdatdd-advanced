package pl.sdacademy.sdatddadvanced.communicator;


import lombok.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Optional;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"subscribedChannels"})
public class User {
  private String email;
  private String name;
  private List<Channel> subscribedChannels;
  private Communicator communicator;

  public Optional<Channel> subscribe(final String channelName) {
    final Optional<Channel> channelOptional = findPublicChannelByName(channelName);
    channelOptional.ifPresent(this::handleChannelSubscription);
    return channelOptional;
  }

  private Optional<Channel> findPublicChannelByName(final String channelName) {
    return communicator.getPublicChannels()
        .stream()
        .filter(existingChannel -> existingChannel.getName().equals(channelName))
        .findFirst();
  }

  private void handleChannelSubscription(final Channel channel) {
    channel.subscribe(this);
    subscribedChannels.add(channel);
    final List<String> allExistingMessages = channel.getAllReadableMessages();
    saveMessages(channel.getName(), allExistingMessages, StandardOpenOption.CREATE);
  }

  private void saveMessages(final String channelName, final List<String> messages,
                            final OpenOption openOption) {
    try {
      Files.write(getUsersChannelFilePath(channelName),
          messages, openOption);
    } catch (final IOException exp) {
      throw new SlackException("Failed to save messages history for user " + name, exp);
    }
  }

  private void saveMessages(final String channelName, final String message,
                            final OpenOption openOption) {
    saveMessages(channelName, List.of(message), openOption);
  }

  private Path getUsersChannelFilePath(final String channelName) {
    return Paths.get("/tmp" + "/" + channelName + "_" + name + ".txt");
  }

  public void sendMessage(final String messageText, final String channelName) {
    findPublicChannelByName(channelName)
        .ifPresent(channel -> sendMessage(messageText, channel));
  }

  private void sendMessage(final String messageText, final Channel channel) {
    if (!subscribedChannels.contains(channel)) {
      channel.subscribe(this);
    }
    channel.sendMessage(this, messageText);
  }

  public void handleNewMessage(final String channelName, final SlackMessage slackMessage) {
    saveMessages(channelName, slackMessage.getReadable(), StandardOpenOption.APPEND);
  }
}
