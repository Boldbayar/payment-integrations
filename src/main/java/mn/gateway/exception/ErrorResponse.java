package mn.gateway.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

	private Boolean success;
	private String message;
	private Object payload;

	private List<ValidationError> errors;

	@Getter
	@Setter
	@RequiredArgsConstructor
	private static class ValidationError {
		private final String field;
		private final String message;
	}

	public void addValidationError(final String field, final String message) {
		if (Objects.isNull(this.errors)) {
			this.errors = new ArrayList<>();
		}
		this.errors.add(new ValidationError(field, message));
	}

	public ErrorResponse(final String message) {
		super();
		this.message = message;
	}
}
