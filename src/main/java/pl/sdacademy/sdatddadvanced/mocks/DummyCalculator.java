package pl.sdacademy.sdatddadvanced.mocks;

import pl.sdacademy.sdatddadvanced.arguments.enums.User;
import pl.sdacademy.sdatddadvanced.exceptions.UserNotFoundException;
import pl.sdacademy.sdatddadvanced.exceptions.UserRepository;

import java.util.List;

public class DummyCalculator {

  private final SomeDependency someDependency;
  private final UserRepository userRepository;

  public DummyCalculator(final SomeDependency someDependency, final UserRepository userRepository) {
    this.someDependency = someDependency;
    this.userRepository = userRepository;
  }

  public Integer addTwo(int value) {
    return value + someDependency.getNumberTwo();
  }

  public Long countExistingUsers(List<String> emailsToSearch) {
    return emailsToSearch.stream().filter(x -> {
      try {
        return userRepository.loadByEmail(x) != null;
      } catch (UserNotFoundException e) {
        return false;
      }
    }).count();
  }
}
