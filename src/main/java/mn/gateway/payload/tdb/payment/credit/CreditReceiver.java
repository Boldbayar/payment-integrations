package mn.gateway.payload.tdb.payment.credit;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreditReceiver {

  @JacksonXmlProperty(localName = "Nm")
  private String name;
}
