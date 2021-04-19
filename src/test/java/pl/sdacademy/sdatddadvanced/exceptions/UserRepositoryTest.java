package pl.sdacademy.sdatddadvanced.exceptions;

import org.junit.jupiter.api.Test;
import pl.sdacademy.sdatddadvanced.arguments.enums.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserRepositoryTest {

    private final UserRepository userRepository = new UserRepository();

    @Test
    void shouldThrowWhenAddingUserWithAlreadyExistingEmail() throws EmailAlreadyTakenException {
        User user = User.builder()
                .email("test@test.com")
                .build();
        userRepository.add(user);

        final EmailAlreadyTakenException exp =
                assertThrows(EmailAlreadyTakenException.class, () -> userRepository.add(user));
        assertThat(exp.getMessage()).isEqualTo("Email already taken exception");
        assertThat(exp.getCause()).isNull();
    }

    @Test
    void shouldThrowWhenLoadingNonExistingUser() {
        assertThatExceptionOfType(UserNotFoundException.class)
                .isThrownBy(() -> userRepository.loadByEmail("test@test.com"))
                .withMessage("User with email does not exist")
                .withNoCause();
    }
}
