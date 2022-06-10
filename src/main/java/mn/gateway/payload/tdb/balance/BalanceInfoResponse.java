package mn.gateway.payload.tdb.balance;

import java.util.Date;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceInfoResponse {

  @JacksonXmlProperty(localName = "RptDt")
  private Date reportedDate;

  @JacksonXmlProperty(localName = "ABal")
  private String availableBalance;

  @JacksonXmlProperty(localName = "Bal")
  private String balance;
}
