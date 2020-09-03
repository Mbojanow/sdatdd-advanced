package pl.sdacademy.sdatddadvanced.arguments.enums;

public class CreateAction extends UserAction {
  public CreateAction(final User user) {
    super(() -> {
      System.out.println("CREATING...");
    }, AccessType.CREATE, user);
  }
}
