package mn.gateway.payload.tdb.payment;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;
import mn.gateway.payload.tdb.base.header.TransferHeader;

@Getter
@Setter
@JacksonXmlRootElement(localName = "Document")
public class TDBPaymentTransaction {

  @JacksonXmlProperty(localName = "GrpHdr")
  private TransferHeader header;

  @JacksonXmlProperty(localName = "PmtInf")
  private TDBPayment payment;
}
