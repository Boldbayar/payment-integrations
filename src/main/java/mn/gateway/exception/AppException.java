package mn.gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public AppException(final String message) {
    super(message);
  }

  public AppException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
