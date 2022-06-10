package mn.gateway.payload.request.payment.tdb;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseTDBRequest {

  private String serviceUrl;

  @NotBlank private String plainXMLRequest;
}
