package pl.sdacademy.sdatddadvanced.arguments.enums;

public class DeleteAction extends UserAction {
  public DeleteAction(final User user) {
    super(() -> {
      System.out.println("DELETING...");
    }, AccessType.DELETE, user);
  }
}
