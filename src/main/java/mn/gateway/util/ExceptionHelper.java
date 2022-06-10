package mn.gateway.util;

import java.util.ArrayList;
import java.util.List;

import javax.validation.UnexpectedTypeException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;
import mn.gateway.exception.ErrorResponse;
import mn.gateway.exception.FileStorageException;
import mn.gateway.exception.ResourceNotFoundException;

@Slf4j
@ControllerAdvice
public class ExceptionHelper {

	@ExceptionHandler(value = {ResourceNotFoundException.class})
	public ResponseEntity<Object> handleInvalidInputException(final ResourceNotFoundException ex) {

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = {Unauthorized.class})
	public ResponseEntity<Object> handleUnauthorizedException(final Unauthorized ex) {

		log.error("Unauthorized Exception: ", ex.getMessage());

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = {FileStorageException.class})
	public ResponseEntity<Object> handleBusinessException(final FileStorageException ex) {

		log.error("Business Exception: ", ex.getMessage());

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleException(final Exception ex) {

		log.error("Exception: ", ex + ex.getMessage());

		// return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(this.buildInternalError(ex.getMessage()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(
			final MethodArgumentNotValidException ex, final WebRequest request) {
		return ResponseEntity.unprocessableEntity().body(this.buildErrors(ex.getFieldErrors()));
	}

	@ExceptionHandler({
		BindException.class,
		HttpMessageNotReadableException.class,
		UnexpectedTypeException.class
	})
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(
			final BindException ex, final WebRequest request) {
		return ResponseEntity.unprocessableEntity().body(this.buildErrors(ex.getFieldErrors()));
	}

	private ErrorResponse buildErrors(final List<FieldError> errors) {
		final var errorResponse = new ErrorResponse();
		errorResponse.setSuccess(false);

		final List<String> messages = new ArrayList<>();
		for (final FieldError fieldError : errors) {
			messages.add(fieldError.getField() + " - "  + fieldError.getDefaultMessage());
		}

		final var mergedErrors = String.join(", ", messages);
		errorResponse.setMessage(mergedErrors);

		return errorResponse;
	}

	private ErrorResponse buildInternalError(final String errorMessage) {
		final var errorResponse = new ErrorResponse();
		errorResponse.setSuccess(false);
		errorResponse.setMessage(errorMessage);

		return errorResponse;
	}
}
