package mn.gateway.payload.tdb.statement;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JacksonXmlRootElement(localName = "Ntry")
public class StatementInfoResponse {

  @JacksonXmlProperty(localName = "NtryRef")
  private String entryRef;

  @JacksonXmlProperty(localName = "Amt")
  private BigDecimal amount;

  @JacksonXmlProperty(localName = "TxRt")
  private BigDecimal transactionRate;

  @JacksonXmlProperty(localName = "TxDt")
  private Date transactionDate;

  @JsonFormat(pattern = "MM/dd/yyyy hh:mm:ss a")
  @JacksonXmlProperty(localName = "TxPostDate")
  private Date transactionPostDate;

  @JacksonXmlProperty(localName = "TxTime")
  private String transactionTime;

  @JacksonXmlProperty(localName = "CtAcct")
  private String contraAccount;

  @JacksonXmlProperty(localName = "TxAddInf")
  private String transactionDescription;

  @JacksonXmlProperty(localName = "CtAcntOrg")
  private String originalAccount;

  @JacksonXmlProperty(localName = "CtBankNo")
  private Integer bankNumber;

  @JacksonXmlProperty(localName = "CtActnName")
  private String accountName;
}
