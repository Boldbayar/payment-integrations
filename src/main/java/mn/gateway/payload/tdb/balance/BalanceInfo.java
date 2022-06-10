package mn.gateway.payload.tdb.balance;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceInfo {

  @JacksonXmlProperty(localName = "IBAN")
  private String accountNumber;

  @JacksonXmlProperty(localName = "Ccy")
  private String currency;
}
