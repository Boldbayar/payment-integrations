package mn.gateway.payload.tdb.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mn.gateway.payload.tdb.payment.response.TDBPaymentResponse;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiPaymentResponse {

  private TDBPaymentResponse tdbResponse;
  private String tdbRequest;
}
