package pl.sdacademy.sdatddadvanced.exceptions;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.sdacademy.sdatddadvanced.arguments.enums.User;

class MessageSenderTest {

  private EmailClient emailClient;
  private UserRepository userRepository;
  private MessageSender messageSender;

  @BeforeEach
  void setUp() {
    EmailClient emailClient = new EmailClient();
    UserRepository userRepository = new UserRepository();
    messageSender = new MessageSender(userRepository, emailClient);
  }

  @Test
  void shouldThrowWhenSenderDoesNotExist() {
    final User sender = User.builder().firstName("Andrzej").build();
    final User recipent = User.builder().firstName("Ala").build();

    assertThatExceptionOfType(MessageActionException.class)
        .isThrownBy(() -> messageSender.sendMessage(sender, recipent, "dupa"))
        .withMessage("Failed to send message")
        .withCauseInstanceOf(UserNotFoundException.class);

    assertThatThrownBy(() -> messageSender.sendMessage(sender, recipent, "dupa"))
        .isInstanceOf(MessageActionException.class)
        .withFailMessage("Failed to send message")
        .hasCauseExactlyInstanceOf(UserNotFoundException.class);
  }

}