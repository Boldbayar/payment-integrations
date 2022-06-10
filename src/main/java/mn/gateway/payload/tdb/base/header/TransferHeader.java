package mn.gateway.payload.tdb.base.header;

import java.math.BigDecimal;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferHeader extends BaseHeader {

  @JacksonXmlProperty(localName = "NbOfTxs")
  private Integer batchCount;

  @JacksonXmlProperty(localName = "CtrlSum")
  private BigDecimal amountSum;
}
