package mn.gateway.payload.tdb.credentials;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;
import mn.gateway.payload.tdb.credentials.password.Passwords;

@Getter
@Setter
public class BaseCredentials {

  @JacksonXmlProperty(localName = "Lang")
  private Integer language;

  @JacksonXmlProperty(localName = "LoginID")
  private String loginId;

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "Pwds")
  private List<Passwords> passwords;
}
