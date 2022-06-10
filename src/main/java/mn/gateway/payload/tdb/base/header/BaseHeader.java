package mn.gateway.payload.tdb.base.header;

import java.util.Date;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;
import mn.gateway.payload.tdb.credentials.BaseCredentials;
import mn.gateway.payload.tdb.organization.InitgPty;

@Getter
@Setter
public class BaseHeader {

  @JacksonXmlProperty(localName = "MsgId")
  private String traceNumber;

  @JacksonXmlProperty(localName = "CreDtTm")
  private Date createdDate;

  @JacksonXmlProperty(localName = "TxsCd")
  private Integer serviceCode;

  @JacksonXmlProperty(localName = "InitgPty")
  private InitgPty organization;

  @JacksonXmlProperty(localName = "Crdtl")
  private BaseCredentials credentials;
}
