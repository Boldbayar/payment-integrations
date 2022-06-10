package mn.gateway.payload.tdb.credentials;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Credentials extends BaseCredentials {

  @JacksonXmlProperty(localName = "RoleID")
  private Integer roleId;
}
