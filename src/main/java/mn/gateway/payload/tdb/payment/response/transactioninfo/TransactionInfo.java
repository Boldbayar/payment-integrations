package mn.gateway.payload.tdb.payment.response.transactioninfo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionInfo {

	@JacksonXmlProperty(localName = "StsId")
	private String status;

	@JacksonXmlProperty(localName = "Rst")
	private TransactionResult result;

	@JacksonXmlProperty(localName = "TxFee")
	private TransactionFee fee;
}
