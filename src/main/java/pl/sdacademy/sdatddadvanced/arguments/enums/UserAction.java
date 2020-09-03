package pl.sdacademy.sdatddadvanced.arguments.enums;

public class UserAction extends Action {

  private final User user;

  public UserAction(final Runnable action, final AccessType requiredAccessType, final User user) {
    super(action, requiredAccessType);
    this.user = user;
  }

  @Override
  public boolean canRun() {
    return false;
  }
}
