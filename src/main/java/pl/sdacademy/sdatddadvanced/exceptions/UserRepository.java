package pl.sdacademy.sdatddadvanced.exceptions;

import pl.sdacademy.sdatddadvanced.arguments.enums.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

  private final List<User> users = new ArrayList<>();

  public User loadByEmail(final String email) throws UserNotFoundException {
    Optional<User> user = users.stream().filter(x -> x.getEmail().equals(email))
        .findFirst();
    if (user.isPresent()) {
      return user.get();
    }
    throw new UserNotFoundException("User with email does not exist");
  }

  public void add(User user) throws EmailAlreadyTakenException {
    if (users.stream().anyMatch(x -> x.getEmail().equals(user.getEmail()))) {
      throw new EmailAlreadyTakenException("Email already taken exception");
    }
    users.add(user);
  }

  public void removeUser(final User user) throws UserNotFoundException {
    if (!users.contains(user)) {
      throw new UserNotFoundException("Cannot remove non existing user");
    }
    users.remove(user);
  }
}
