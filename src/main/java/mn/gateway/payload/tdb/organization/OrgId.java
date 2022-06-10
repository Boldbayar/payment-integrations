package mn.gateway.payload.tdb.organization;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrgId {

  @JacksonXmlProperty(localName = "AnyBIC")
  private String anyBIC;
}
