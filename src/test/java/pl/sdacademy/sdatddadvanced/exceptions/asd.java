package pl.sdacademy.sdatddadvanced.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import pl.sdacademy.sdatddadvanced.arguments.enums.Action;
import pl.sdacademy.sdatddadvanced.arguments.enums.CreateAction;
import pl.sdacademy.sdatddadvanced.arguments.enums.Role;
import pl.sdacademy.sdatddadvanced.arguments.enums.User;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

public class asd {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outContent));
  }

  @MethodSource("providerArguments")
  @ParameterizedTest
  void qwe(Class<? extends Action> type, User user) throws IllegalAccessException, InvocationTargetException, InstantiationException {
    Action o = (Action)type.getDeclaredConstructors()[0].newInstance(user);
    o.execute();
    originalOut.toString();

  }


  static Stream<? extends Arguments> providerArguments() {
    return Stream.of(Arguments.of(
        CreateAction.class, User.builder().role(Role.CRUD_ADMIN).build()
    ));
  }

}
