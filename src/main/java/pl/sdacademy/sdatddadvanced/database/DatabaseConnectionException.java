package pl.sdacademy.sdatddadvanced.database;

public class DatabaseConnectionException extends RuntimeException {
  public DatabaseConnectionException() {
    super();
  }

  public DatabaseConnectionException(final String message) {
    super(message);
  }

  public DatabaseConnectionException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public DatabaseConnectionException(final Throwable cause) {
    super(cause);
  }

  protected DatabaseConnectionException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
