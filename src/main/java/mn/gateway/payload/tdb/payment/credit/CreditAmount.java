package mn.gateway.payload.tdb.payment.credit;

import java.math.BigDecimal;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditAmount {

  @JacksonXmlProperty(localName = "InstdAmt")
  private BigDecimal instructedAmount;

  @JacksonXmlProperty(localName = "EqvtAmt")
  private BigDecimal tdbEqualAmount;

  public CreditAmount(final BigDecimal instructedAmount) {
    super();
    this.instructedAmount = instructedAmount;
    this.tdbEqualAmount = instructedAmount;
  }
}
