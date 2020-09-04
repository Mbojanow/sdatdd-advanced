package pl.sdacademy.sdatddadvanced.exceptions;

import pl.sdacademy.sdatddadvanced.arguments.enums.User;

public class EmailClient {

  public void send(final User from, final User to, final Message emailMessage) {
    System.out.println(String.format("Sending message %s from %s to %s", emailMessage.toString(), from.toString(), to.toString()));
  }
}
