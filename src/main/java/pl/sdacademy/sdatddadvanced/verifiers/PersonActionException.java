package pl.sdacademy.sdatddadvanced.verifiers;

public class PersonActionException extends RuntimeException {
  public PersonActionException() {
    super();
  }

  public PersonActionException(final String message) {
    super(message);
  }

  public PersonActionException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public PersonActionException(final Throwable cause) {
    super(cause);
  }

  protected PersonActionException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
