package mn.gateway.payload.tdb.credentials.password;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passwords {

  @JacksonXmlProperty(localName = "PwdType")
  private Integer passType;

  @JacksonXmlProperty(localName = "Pwd")
  private String pass;
}
