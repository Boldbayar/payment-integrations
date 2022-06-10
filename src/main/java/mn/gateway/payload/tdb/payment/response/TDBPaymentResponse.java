package mn.gateway.payload.tdb.payment.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;
import mn.gateway.payload.tdb.base.header.StatementHeader;
import mn.gateway.payload.tdb.payment.response.transactioninfo.TransactionInfoWrapper;

@Getter
@Setter
@JacksonXmlRootElement(localName = "Document")
public class TDBPaymentResponse {

  @JacksonXmlProperty(localName = "GrpHdr")
  private StatementHeader header;

  @JacksonXmlProperty(localName = "OrgnlPmtInfAndSts")
  private TransactionInfoWrapper transactionInfoWrapper;
}
