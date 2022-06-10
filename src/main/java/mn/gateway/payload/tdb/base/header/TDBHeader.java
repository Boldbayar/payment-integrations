package mn.gateway.payload.tdb.base.header;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TDBHeader extends BaseHeader {

  @JacksonXmlProperty(localName = "NbOfTxs")
  private Integer batchCount;
}
