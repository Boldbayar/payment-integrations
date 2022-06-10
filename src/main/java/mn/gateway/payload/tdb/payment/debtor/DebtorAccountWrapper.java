package mn.gateway.payload.tdb.payment.debtor;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DebtorAccountWrapper {

  @JacksonXmlProperty(localName = "IBAN")
  private String accountNumber;
}
