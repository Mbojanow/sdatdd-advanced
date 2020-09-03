package pl.sdacademy.sdatddadvanced.arguments.enums;

public class UpdateAction extends UserAction {
  public UpdateAction(final User user) {
    super(() -> {
      System.out.println("UPDATING...");
    }, AccessType.UPDATE, user);
  }
}
