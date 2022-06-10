package mn.gateway.payload.tdb.payment.debtor;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Debtor {

  @JacksonXmlProperty(localName = "Nm")
  private String name;
}
