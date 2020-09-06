package pl.sdacademy.sdatddadvanced.exceptions;

import pl.sdacademy.sdatddadvanced.arguments.enums.User;

public class MessageSender {

  private final UserRepository userRepository;
  private final EmailClient emailClient;

  public MessageSender(final UserRepository userRepository, final EmailClient emailClient) {
    this.userRepository = userRepository; // new UserRepository
    this.emailClient = emailClient; // new EmailCLient
  }

  public Message sendMessage(final User from, final User to, final String value) {
    final User sender;
    final User recipient;
    try {
      sender = userRepository.loadByEmail(from.getEmail());
      recipient = userRepository.loadByEmail(to.getEmail());
      System.out.println("Sending message...");
      final Message message = new Message(sender.getEmail(), recipient.getEmail(), value);
      emailClient.send(from, to, message);
      return message;
    } catch (UserNotFoundException e) {
      throw new MessageActionException("Failed to send message", MessageActionType.SEND, e);
    }
  }
}
