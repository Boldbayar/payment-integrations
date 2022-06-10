package mn.gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InsufficientException extends RuntimeException {

  private static final long serialVersionUID = 8033811426098557091L;

  public InsufficientException(final String message) {
    super(message);
  }

  public InsufficientException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
