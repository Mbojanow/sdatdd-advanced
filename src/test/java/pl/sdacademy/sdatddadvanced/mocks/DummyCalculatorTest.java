package pl.sdacademy.sdatddadvanced.mocks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.filter;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import pl.sdacademy.sdatddadvanced.arguments.enums.User;
import pl.sdacademy.sdatddadvanced.exceptions.UserNotFoundException;
import pl.sdacademy.sdatddadvanced.exceptions.UserRepository;

class DummyCalculatorTest {

  @Test
  void shouldAddTwo() {
    final UserRepository userRepository = Mockito.mock(UserRepository.class);
    final SomeDependency someDependency = Mockito.mock(SomeDependency.class);
    DummyCalculator dummyCalculator = new DummyCalculator(someDependency, userRepository);
    when(someDependency.getNumberTwo()).thenReturn(5);

    final Integer actualValue = dummyCalculator.addTwo(3);

    assertThat(actualValue).isEqualTo(8);
//    System.out.println(dummyCalculator.addTwo(3));
//    System.out.println(dummyCalculator.countExistingUsers(List.of("asd")));
  }

  @Test
  void shouldCountUsers() throws UserNotFoundException {
    final UserRepository userRepository = Mockito.mock(UserRepository.class);
    final SomeDependency someDependency = Mockito.mock(SomeDependency.class);
    DummyCalculator dummyCalculator = new DummyCalculator(someDependency, userRepository);
    final String emailA = "a";
    final String emailB = "b";
    final String emailC = "c";
    final String emailD = "d";
    when(userRepository.loadByEmail(emailA)).thenReturn(new User());
    when(userRepository.loadByEmail(emailB)).thenReturn(new User());
    when(userRepository.loadByEmail(emailC)).thenReturn(null);
    when(userRepository.loadByEmail(emailD)).thenThrow(new UserNotFoundException());

    final Long count = dummyCalculator
        .countExistingUsers(List.of(emailA, emailB, emailC, emailD));

    assertThat(count).isEqualTo(2);
  }

}