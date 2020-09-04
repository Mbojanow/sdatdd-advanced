package pl.sdacademy.sdatddadvanced.exceptions;

public class EmailAlreadyTakenException extends Exception {
  public EmailAlreadyTakenException() {
    super();
  }

  public EmailAlreadyTakenException(final String message) {
    super(message);
  }

  public EmailAlreadyTakenException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public EmailAlreadyTakenException(final Throwable cause) {
    super(cause);
  }

  protected EmailAlreadyTakenException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
