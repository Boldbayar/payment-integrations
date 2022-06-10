package mn.gateway.payload.tdb.payment;

import java.math.BigDecimal;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;
import mn.gateway.payload.tdb.payment.credit.CreditTransfer;
import mn.gateway.payload.tdb.payment.debtor.Debtor;
import mn.gateway.payload.tdb.payment.debtor.DebtorAccount;

@Getter
@Setter
@JacksonXmlRootElement(localName = "PmtInf")
public class TDBPayment {

  @JacksonXmlProperty(localName = "NbOfTxs")
  private Integer batchCount;

  @JacksonXmlProperty(localName = "CtrlSum")
  private BigDecimal totalAmount;

  @JacksonXmlProperty(localName = "ForT")
  private String importantAmount;

  @JacksonXmlProperty(localName = "Dbtr")
  private Debtor debtor;

  @JacksonXmlProperty(localName = "DbtrAcct")
  private DebtorAccount debtorAccount;

  @JacksonXmlProperty(localName = "CdtTrfTxInf")
  private CreditTransfer creditTransfer;
}
