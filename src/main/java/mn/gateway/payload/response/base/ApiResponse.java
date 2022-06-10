package mn.gateway.payload.response.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {

	private Boolean success;
	private String message;
	private Object payload;

	public ApiResponse(final Boolean success, final String message,
			final Object payload) {
		this.success = success;
		this.message = message;
		this.payload = payload;
	}

	public ApiResponse(final Boolean success, final String message) {
		this.success = success;
		this.message = message;
	}

	public ApiResponse() {
	}

	public static ApiResponse ErrorApiResponse() {

		final var response = new ApiResponse();
		response.setSuccess(false);
		response.setMessage("Системийн алдаа гарлаа");

		return response;
	}
}
