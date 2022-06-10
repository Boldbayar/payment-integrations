package mn.gateway.payload.tdb.payment.credit.receiver;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReceiverBank {

  @JacksonXmlProperty(localName = "FinInstnId")
  private ReceiverBankIdentification identification;
}
