package mn.gateway.payload.tdb.payment.response.transactioninfo;

import java.math.BigDecimal;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionFee {

	@JacksonXmlProperty(localName = "Nm")
	private String description;

	@JacksonXmlProperty(localName = "Amt")
	private BigDecimal amount;

	@JacksonXmlProperty(localName = "Ccy")
	private String currency;
}
