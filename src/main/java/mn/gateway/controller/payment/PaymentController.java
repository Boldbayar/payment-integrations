package mn.gateway.controller.payment;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mn.gateway.payload.request.payment.tdb.BaseTDBRequest;
import mn.gateway.payload.tdb.api.ApiBalanceRequest;
import mn.gateway.payload.tdb.api.ApiPaymentRequest;
import mn.gateway.payload.tdb.statement.StatementRequestInfo;
import mn.gateway.service.v1.payment.TDBService;

@Slf4j
@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

	private final TDBService tdbService;

	@Autowired
	public PaymentController(final TDBService tdbService) {
		this.tdbService = tdbService;
	}

	@PostMapping("statement")
	public ResponseEntity<Object> getStatement(@Valid @RequestBody final StatementRequestInfo request) {
		try {
			return ResponseEntity.ok(this.tdbService.getAccountStatement(request));
		}
		catch(final Exception ex ){
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@PostMapping("balance")
	public ResponseEntity<Object> balance(@Valid @RequestBody final ApiBalanceRequest request) {
		try {
			return ResponseEntity.ok(this.tdbService.getAccountBalance(request));
		} catch(final Exception ex ){
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@PostMapping("transfer")
	public ResponseEntity<Object> transfer(@Valid @RequestBody final ApiPaymentRequest request) {
		try {
			var response = this.tdbService.transfer(request);
			if (response.getTdbResponse().getHeader().getResponseCode() == 130) {
				response = this.tdbService.transfer(request);
			}
			return ResponseEntity.ok(response);
		} catch(final Exception ex ){
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@PostMapping("tdb-dynamic")
	public ResponseEntity<Object> tdbInitiate(@RequestBody final BaseTDBRequest request) {
		try {
			return ResponseEntity.ok(this.tdbService.dynamicCall(request));
		} catch(final Exception ex ){
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}
}
