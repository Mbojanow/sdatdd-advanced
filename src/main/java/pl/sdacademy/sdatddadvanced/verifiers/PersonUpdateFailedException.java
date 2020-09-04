package pl.sdacademy.sdatddadvanced.verifiers;

public class PersonUpdateFailedException extends RuntimeException {
  public PersonUpdateFailedException() {
    super();
  }

  public PersonUpdateFailedException(final String message) {
    super(message);
  }

  public PersonUpdateFailedException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public PersonUpdateFailedException(final Throwable cause) {
    super(cause);
  }

  protected PersonUpdateFailedException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
