package mn.gateway.payload.tdb.statement.wrapper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;
import mn.gateway.payload.tdb.base.Document;
import mn.gateway.payload.tdb.statement.StatementRequestInfo;

@Getter
@Setter
@JacksonXmlRootElement(localName = "Document")
public class StatementRequest extends Document {

  @JacksonXmlProperty(localName = "EnqInf")
  private StatementRequestInfo statementInfo;
}
