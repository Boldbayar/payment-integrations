package mn.gateway.payload.tdb.balance.wrapper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;
import mn.gateway.payload.tdb.balance.BalanceInfoResponse;
import mn.gateway.payload.tdb.base.header.StatementHeader;

@Getter
@Setter
@JacksonXmlRootElement(localName = "Document")
public class BalanceResponse {

  @JacksonXmlProperty(localName = "GrpHdr")
  private StatementHeader header;

  @JacksonXmlProperty(localName = "EnqRsp")
  private BalanceInfoResponse enqResponse;
}
