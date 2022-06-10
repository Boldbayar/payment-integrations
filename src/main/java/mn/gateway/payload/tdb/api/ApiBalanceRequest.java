package mn.gateway.payload.tdb.api;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiBalanceRequest {

  @NotBlank private String accountNumber;
  @NotBlank private String currency;

  @NotBlank private String orgId;
  @NotBlank private String loginId;
  @NotBlank private String password;
}
