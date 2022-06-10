package mn.gateway.payload.request.bankinfo;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import mn.gateway.model.bankinfo.BankCurrency;

@Getter
@Setter
public class BankInfoCreateRequest {

  @NotNull private UUID userId;

  @NotNull private String bankCode;
  @NotNull private BankCurrency currency;

  @NotEmpty private String accountNumber;
  @NotEmpty private String accountName;
}
