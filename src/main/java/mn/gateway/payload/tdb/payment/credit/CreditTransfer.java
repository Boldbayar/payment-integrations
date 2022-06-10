package mn.gateway.payload.tdb.payment.credit;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mn.gateway.payload.tdb.payment.credit.receiver.ReceiverBank;
import mn.gateway.payload.tdb.payment.credit.receiver.TransactionDescription;

@Getter
@Setter
@NoArgsConstructor
public class CreditTransfer {

  @JacksonXmlProperty(localName = "Amt")
  private CreditAmount amount;

  @JacksonXmlProperty(localName = "Cdtr")
  private CreditReceiver receiver;

  @JacksonXmlProperty(localName = "CdtrAcct")
  private CreditReceiverAccount receiverAccount;

  @JacksonXmlProperty(localName = "CdtrAgt")
  private ReceiverBank receiverBank;

  @JacksonXmlProperty(localName = "RmtInf")
  private TransactionDescription transactionDescription;
}
