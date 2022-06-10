package mn.gateway.payload.request.bankinfo;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import mn.gateway.model.bankinfo.BankCurrency;

@Getter
@Setter
public class BankInfoEditRequest {

  @NotNull private UUID userId;

  private String bankCode;
  private BankCurrency currency;

  private String accountNumber;
  private String accountName;
}
