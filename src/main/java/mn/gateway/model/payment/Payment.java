package mn.gateway.model.payment;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;
import mn.gateway.util.serializer.BigDecimalSerializer;

@Getter
@Setter
public class Payment implements Serializable {

	private static final long serialVersionUID = 3485839658519501843L;


	private UUID id;

	private Long version;

	@JsonSerialize(using = BigDecimalSerializer.class)
	private BigDecimal amount;
	@JsonSerialize(using = BigDecimalSerializer.class)
	private BigDecimal paidAmount;
	@JsonSerialize(using = BigDecimalSerializer.class)
	private BigDecimal currentTaxPercentage;
	@JsonSerialize(using = BigDecimalSerializer.class)
	private BigDecimal currentTaxAmount;
	@JsonSerialize(using = BigDecimalSerializer.class)
	private BigDecimal currentNetAmount;

	private String number;
	private String invoiceId;

	private PaymentStatus status;
	private PaymentType type;


	private String initiateRequest;
	private String initiateResponse;
	private String checkResponse;

	private boolean isRefundVerified;
	private boolean isVerfied;
	private boolean isVerifiedCron;


	private int verifiedCount;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date verifiedCronDate;

}
