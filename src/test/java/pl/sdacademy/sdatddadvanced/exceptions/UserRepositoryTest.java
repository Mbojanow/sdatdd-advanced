package pl.sdacademy.sdatddadvanced.exceptions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserRepositoryTest {

  private UserRepository userRepository = new UserRepository();

  @Test
  void shouldThrowWhenUserNotFound() {
    final UserNotFoundException userNotFoundException =
        assertThrows(UserNotFoundException.class, () -> userRepository.loadByEmail("test@wp.pl"));

    assertThat(userNotFoundException.getMessage()).contains("not exist");
    assertThat(userNotFoundException.getCause()).isNull();
  }

}