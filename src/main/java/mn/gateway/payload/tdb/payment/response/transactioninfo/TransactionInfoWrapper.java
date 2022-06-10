package mn.gateway.payload.tdb.payment.response.transactioninfo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionInfoWrapper {

  @JacksonXmlProperty(localName = "TxnInfAndSts")
  private TransactionInfo transactionInfo;
}
