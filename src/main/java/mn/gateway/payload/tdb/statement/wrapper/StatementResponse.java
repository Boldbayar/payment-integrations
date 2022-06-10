package mn.gateway.payload.tdb.statement.wrapper;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;
import mn.gateway.payload.tdb.base.header.StatementHeader;
import mn.gateway.payload.tdb.statement.StatementInfoResponse;

@Getter
@Setter
@JacksonXmlRootElement(localName = "Document")
public class StatementResponse {

  @JacksonXmlProperty(localName = "GrpHdr")
  private StatementHeader header;

  @JacksonXmlProperty(localName = "EnqRsp")
  private List<StatementInfoResponse> enqResponse;
}
