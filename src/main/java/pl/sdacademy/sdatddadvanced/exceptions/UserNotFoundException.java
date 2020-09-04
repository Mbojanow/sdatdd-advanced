package pl.sdacademy.sdatddadvanced.exceptions;

public class UserNotFoundException extends Exception {
  public UserNotFoundException() {
    super();
  }

  public UserNotFoundException(final String message) {
    super(message);
  }

  public UserNotFoundException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public UserNotFoundException(final Throwable cause) {
    super(cause);
  }

  protected UserNotFoundException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
