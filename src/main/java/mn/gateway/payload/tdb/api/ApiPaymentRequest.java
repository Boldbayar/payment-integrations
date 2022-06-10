package mn.gateway.payload.tdb.api;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiPaymentRequest {

	private BigDecimal totalAmount;

	@NotBlank private String receiverName;
	@NotBlank private String receiverAccount;
	@NotBlank private String receiverBankCode;
	@NotBlank private String receiverCurrency;
	@NotBlank private String description;

	private boolean interTransfer;
}
