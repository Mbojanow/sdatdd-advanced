package pl.sdacademy.sdatddadvanced.database;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.sdacademy.sdatddadvanced.arguments.enums.User;
import pl.sdacademy.sdatddadvanced.exceptions.EmailAlreadyTakenException;
import pl.sdacademy.sdatddadvanced.exceptions.UserNotFoundException;
import pl.sdacademy.sdatddadvanced.exceptions.UserRepository;

@ExtendWith(MockitoExtension.class)
class DatabaseStore2Test {

  @Mock
  private DatabaseConnection databaseConnection;

  @Mock
  private UserRepository userRepository;

  @InjectMocks // rownowazne z databaseStore2 = new DatabaseStore2(databaseConnection)
  private DatabaseStore2 databaseStore2;

  @Test
  void shouldOpenConnectionAndAddData() throws EmailAlreadyTakenException {
    final String data = "data";
    when(databaseConnection.isOpened()).thenReturn(false, true);

    databaseStore2.addData(data);

    verify(userRepository).add(User.builder().firstName(data).build());
  }

  @Test
  void shouldOpenConnectionAndAddData2() throws EmailAlreadyTakenException, UserNotFoundException {
    final String data = "data";
    int[] index = { 0 };
    when(databaseConnection.isOpened()).thenAnswer(invocationOnMock -> {
      if (index[0]++ == 0) {
        return false;
      }
      return true;
    });
    // doNothing().when(userRepository).removeUser(new User()); // powoduje UnnecessaryStubbingException

    doNothing().when(userRepository).add(User.builder().firstName(data).build());

    databaseStore2.addData(data);
  }

  @Test
  void shouldOpenConnectionAndAddData3() throws EmailAlreadyTakenException {
    final String data = "data";
    final String data2 = "data";
    when(databaseConnection.isOpened()).thenReturn(false, true);

    databaseStore2.addData(data, data2);

    verify(userRepository, times(2)).add(User.builder().firstName(data).build());
  }
}