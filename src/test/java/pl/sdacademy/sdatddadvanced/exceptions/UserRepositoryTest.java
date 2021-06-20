package pl.sdacademy.sdatddadvanced.exceptions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private final UserRepository userRepository = new UserRepository();

    @Test
    void shouldThrowWhenLoadingNonExistingUser() throws UserNotFoundException {
        //given
        String email = "test@email.com";

        //when //then
        assertThatExceptionOfType(UserNotFoundException.class)
                .isThrownBy(() -> userRepository.loadByEmail(email))
                .withMessage("User with email does not exist");


        assertThatThrownBy(() -> userRepository.loadByEmail(email))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessage("User with email does not exist");
    }

}