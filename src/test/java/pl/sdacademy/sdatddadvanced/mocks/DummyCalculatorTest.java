package pl.sdacademy.sdatddadvanced.mocks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
    private SomeDependency someDependency;// = Mockito.mock(SomeDependency.class);

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private DummyCalculator dummyCalculator; // = new DummyCalculator(someDependency, userRepository);

    @Test
    void dummyTest() {
        System.out.println("x");
    }

    @Test
    void shouldAddTwo() {
        Mockito.when(someDependency.getNumberTwo()).thenReturn(3);

        Integer result = dummyCalculator.addTwo(5);

        assertThat(result).isEqualTo(8);
    }

    @Test
    void shouldCountExistingUsers() throws UserNotFoundException {
        String emailA = "ala@test.com";
        String emailB = "jan@test.com";
        String emailC = "ania@test.com";
        Mockito.when(userRepository.loadByEmail(emailA)).thenReturn(User.builder()
                .email(emailA)
                .build());
        Mockito.when(userRepository.loadByEmail(emailB)).thenReturn(null);
        Mockito.when(userRepository.loadByEmail(emailC)).thenThrow(new UserNotFoundException("BOOM"));

        //Mockito.when(userRepository.loadByEmail("asd@test.com")).thenReturn(null);

        //when
        Long count = dummyCalculator.countExistingUsers(List.of(emailA, emailB, emailC));

        //then
        assertThat(count).isEqualTo(1);
    }
}