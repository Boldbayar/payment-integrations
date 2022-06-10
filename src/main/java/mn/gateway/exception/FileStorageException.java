package mn.gateway.exception;

public class FileStorageException extends RuntimeException {

  private static final long serialVersionUID = 7194816784550732277L;

  public FileStorageException(final String message) {
    super(message);
  }

  public FileStorageException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
