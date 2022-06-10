package mn.gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class ResourceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final String resourceName;
  private final String fieldName;
  private final Object fieldValue;

  /** constructor. */
  public ResourceNotFoundException(
      final String resourceName, final String fieldName, final Object fieldValue) {
    super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
    this.resourceName = resourceName;
    this.fieldName = fieldName;
    this.fieldValue = fieldValue;
  }

  public ResourceNotFoundException(final String errorMessage) {
    super(errorMessage);

    this.resourceName = "";
    this.fieldName = "";
    this.fieldValue = "";
  }

  public String getResourceName() {
    return this.resourceName;
  }

  public String getFieldName() {
    return this.fieldName;
  }

  public Object getFieldValue() {
    return this.fieldValue;
  }
}
