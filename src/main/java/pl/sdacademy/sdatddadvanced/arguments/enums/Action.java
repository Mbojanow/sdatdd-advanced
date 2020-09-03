package pl.sdacademy.sdatddadvanced.arguments.enums;

public abstract class Action {

  private static final Runnable NO_ACTION = () -> System.out.println("NO ACTION RUN...");


  private final Runnable action;
  private final AccessType requiredAccessType;

  protected Action(final Runnable action, final AccessType requiredAccessType) {
    this.action = action;
    this.requiredAccessType = requiredAccessType;
  }

  public void execute() {
    if (canRun()) {
      action.run();
    } else {
      NO_ACTION.run();
    }
  }

  public AccessType getRequiredAccessType() {
    return requiredAccessType;
  }

  public abstract boolean canRun();
}
