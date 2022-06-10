package mn.gateway.payload.tdb.statement;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatementRequestInfo {

  @JacksonXmlProperty(localName = "Ccy")
  private String currency;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JacksonXmlProperty(localName = "FrDt")
  private Date startDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JacksonXmlProperty(localName = "ToDt")
  private Date endDate;

  @JacksonXmlProperty(localName = "JrNo")
  private String jourNumber;

  @JacksonXmlProperty(localName = "IBAN")
  private String accountNumber;

  @Override
  public String toString() {
    return "StatementRequestInfo [currency="
        + this.currency
        + ", startDate="
        + this.startDate
        + ", endDate="
        + this.endDate
        + ", jourNumber="
        + this.jourNumber
        + ", accountNumber="
        + this.accountNumber
        + "]";
  }
}
