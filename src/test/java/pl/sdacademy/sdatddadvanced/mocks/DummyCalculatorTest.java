package pl.sdacademy.sdatddadvanced.mocks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.sdacademy.sdatddadvanced.arguments.enums.User;
import pl.sdacademy.sdatddadvanced.exceptions.UserNotFoundException;
import pl.sdacademy.sdatddadvanced.exceptions.UserRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DummyCalculatorTest {

    @Mock
    private SomeDependency someDependency;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private DummyCalculator dummyCalculator;

    @Test
    void shouldCountExistingUsersWhenAllUsersFound() throws UserNotFoundException {
        String email = "test@test.com";
        Mockito.when(userRepository.loadByEmail(email))
                .thenReturn(User.builder().email(email).build());

        final Long result = dummyCalculator.countExistingUsers(List.of(email));

        assertThat(result).isEqualTo(1);
        Mockito.verifyNoInteractions(someDependency);
        Mockito.verify(userRepository).loadByEmail(email); // Ta linijka nie jest wymagana ponieważ Mockito sam sprawdza czy mock został
        // użyty raz
    }

    @Test
    void shouldCountExistingUsersWhenOneNotFound() throws UserNotFoundException {
        //given
        String emailA = "test1@test.com";
        String emailB = "test2@test.com";
        Mockito.when(userRepository.loadByEmail(emailA))
                .thenReturn(User.builder().email(emailA).build());
        Mockito.when(userRepository.loadByEmail(emailB))
                .thenThrow(new UserNotFoundException());

        //when
        final Long result = dummyCalculator.countExistingUsers(List.of(emailA, emailB));

        //then
        assertThat(result).isEqualTo(1);
        Mockito.verifyNoInteractions(someDependency);
        Mockito.verify(userRepository, Mockito.times(2)).loadByEmail(ArgumentMatchers.any());
    }

    @Test
    void shouldAddTwo() {
        int value = 4;
        Mockito.when(someDependency.getNumberTwo()).thenReturn(3);

        int result = dummyCalculator.addTwo(value);

        assertThat(result).isEqualTo(7);
    }


}
