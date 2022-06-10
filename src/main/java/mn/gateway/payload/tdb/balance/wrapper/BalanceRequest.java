package mn.gateway.payload.tdb.balance.wrapper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;
import mn.gateway.payload.tdb.balance.BalanceInfo;
import mn.gateway.payload.tdb.base.Document;

@Getter
@Setter
@JacksonXmlRootElement(localName = "Document")
public class BalanceRequest extends Document {

  @JacksonXmlProperty(localName = "EnqInf")
  private BalanceInfo balanceInfo;
}
