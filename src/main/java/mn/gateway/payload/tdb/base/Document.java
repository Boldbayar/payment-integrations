package mn.gateway.payload.tdb.base;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;
import mn.gateway.payload.tdb.base.header.BaseHeader;

@Getter
@Setter
public class Document {

  @JacksonXmlProperty(localName = "GrpHdr")
  private BaseHeader header;
}
