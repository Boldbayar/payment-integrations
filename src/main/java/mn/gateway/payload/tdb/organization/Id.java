package mn.gateway.payload.tdb.organization;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Id {

  @JacksonXmlProperty(localName = "OrgId")
  private OrgId orgId;
}
