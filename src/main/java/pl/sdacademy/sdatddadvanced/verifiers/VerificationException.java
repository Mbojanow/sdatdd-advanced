package pl.sdacademy.sdatddadvanced.verifiers;

public class VerificationException extends RuntimeException {
  public VerificationException() {
    super();
  }

  public VerificationException(final String message) {
    super(message);
  }

  public VerificationException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public VerificationException(final Throwable cause) {
    super(cause);
  }

  protected VerificationException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
