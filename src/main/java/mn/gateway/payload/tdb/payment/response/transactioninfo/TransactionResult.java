package mn.gateway.payload.tdb.payment.response.transactioninfo;

import java.math.BigDecimal;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionResult {

  @JacksonXmlProperty(localName = "JrNo")
  private String journalNumber;

  @JacksonXmlProperty(localName = "TxDbRate")
  private BigDecimal buyRate;

  @JacksonXmlProperty(localName = "TxCrRate")
  private BigDecimal sellRate;
}
