package mn.gateway.payload.tdb.payment.credit;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import mn.gateway.payload.tdb.payment.credit.receiver.ReceiverAccountWrapper;

@Getter
@Setter
@AllArgsConstructor
public class CreditReceiverAccount {

  @JacksonXmlProperty(localName = "Id")
  private ReceiverAccountWrapper account;

  @JacksonXmlProperty(localName = "Ccy")
  private String currency;
}
