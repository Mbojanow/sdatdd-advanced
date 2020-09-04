package pl.sdacademy.sdatddadvanced.exceptions;

import lombok.Getter;

@Getter
public class MessageActionException extends RuntimeException {
  private final MessageActionType type;

  public MessageActionException(final String message, final MessageActionType type) {
    super(message);
    this.type = type;
  }

  public MessageActionException(final String message, final MessageActionType type, final Throwable cause) {
    super(message, cause);
    this.type = type;
  }


}
