package mn.gateway.service.v1.payment;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import mn.gateway.config.props.tdb.TDBGatewayProperties;
import mn.gateway.payload.request.payment.tdb.BaseTDBRequest;
import mn.gateway.payload.tdb.api.ApiBalanceRequest;
import mn.gateway.payload.tdb.api.ApiPaymentRequest;
import mn.gateway.payload.tdb.api.ApiPaymentResponse;
import mn.gateway.payload.tdb.balance.BalanceInfo;
import mn.gateway.payload.tdb.balance.wrapper.BalanceRequest;
import mn.gateway.payload.tdb.balance.wrapper.BalanceResponse;
import mn.gateway.payload.tdb.base.header.BaseHeader;
import mn.gateway.payload.tdb.base.header.TDBHeader;
import mn.gateway.payload.tdb.base.header.TransferHeader;
import mn.gateway.payload.tdb.credentials.BaseCredentials;
import mn.gateway.payload.tdb.credentials.Credentials;
import mn.gateway.payload.tdb.credentials.password.Passwords;
import mn.gateway.payload.tdb.organization.Id;
import mn.gateway.payload.tdb.organization.InitgPty;
import mn.gateway.payload.tdb.organization.OrgId;
import mn.gateway.payload.tdb.payment.TDBPayment;
import mn.gateway.payload.tdb.payment.TDBPaymentTransaction;
import mn.gateway.payload.tdb.payment.credit.CreditAmount;
import mn.gateway.payload.tdb.payment.credit.CreditReceiver;
import mn.gateway.payload.tdb.payment.credit.CreditReceiverAccount;
import mn.gateway.payload.tdb.payment.credit.CreditTransfer;
import mn.gateway.payload.tdb.payment.credit.receiver.ReceiverAccountWrapper;
import mn.gateway.payload.tdb.payment.credit.receiver.ReceiverBank;
import mn.gateway.payload.tdb.payment.credit.receiver.ReceiverBankIdentification;
import mn.gateway.payload.tdb.payment.credit.receiver.TransactionDescription;
import mn.gateway.payload.tdb.payment.debtor.Debtor;
import mn.gateway.payload.tdb.payment.debtor.DebtorAccount;
import mn.gateway.payload.tdb.payment.debtor.DebtorAccountWrapper;
import mn.gateway.payload.tdb.payment.response.TDBPaymentResponse;
import mn.gateway.payload.tdb.statement.StatementRequestInfo;
import mn.gateway.payload.tdb.statement.wrapper.StatementRequest;
import mn.gateway.payload.tdb.statement.wrapper.StatementResponse;
import mn.gateway.util.CommonUtil;
import mn.gateway.util.constants.TDBConstants;

@Service
public class TDBService {

	private static final String DATE_PATTERN = "yyMMddHH";
	private static final String PREFIX = "TR";

	@Qualifier("tdb-rest")
	private final RestTemplate restTemplate;

	private final XmlMapper xmlMapper;

	private final TDBGatewayProperties tdbGatewayProperties;

	@Autowired
	private TDBService(
			final RestTemplate restTemplate,
			final TDBGatewayProperties tdbGatewayProperties) {

		this.tdbGatewayProperties = tdbGatewayProperties;
		this.restTemplate = restTemplate;

		this.xmlMapper = new XmlMapper();
	}

	public String dynamicCall(final BaseTDBRequest request) {
		final var body = request.getPlainXMLRequest();
		final var headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_XML);

		final HttpEntity<?> entity = new HttpEntity<>(body, headers);
		final var response =
				this.restTemplate.exchange(request.getServiceUrl(), HttpMethod.POST, entity, String.class);

		return response.getBody();
	}

	public StatementResponse getAccountStatement(final StatementRequestInfo statementRequest)
			throws JsonProcessingException {

		final var header = new TDBHeader();
		header.setTraceNumber(CommonUtil.generate(TDBService.PREFIX, TDBService.DATE_PATTERN, 3));
		header.setCreatedDate(new Date());
		header.setServiceCode(TDBConstants.STATEMENT);
		header.setBatchCount(1);



		final var iden = new OrgId();
		iden.setAnyBIC("TDB-ORGID");
		final var orgId = new Id();
		orgId.setOrgId(iden);
		final var org = new InitgPty();
		org.setId(orgId);
		header.setOrganization(org);

		final var creds = new Credentials();
		creds.setLanguage(0);
		creds.setLoginId("TDB-LOGIN");

		final var pwds = new Passwords();
		pwds.setPass("TDB-FIRSTPASS");
		pwds.setPassType(1);
		creds.setPasswords(List.of(pwds));

		creds.setRoleId(1); // TDB_ROLEID
		header.setCredentials(creds);

		final var req = new StatementRequest();
		req.setHeader(header);
		req.setStatementInfo(statementRequest);

		final var body = this.xmlMapper.writeValueAsString(req);
		final var headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_XML);

		final HttpEntity<?> entity = new HttpEntity<>(body, headers);
		final var response =
				this.restTemplate.exchange(
						this.tdbGatewayProperties.getUrl(), HttpMethod.POST, entity, String.class);

		return this.xmlMapper.readValue(response.getBody(), StatementResponse.class);
	}

	public BalanceResponse getAccountBalance(final ApiBalanceRequest apiRequest)
			throws JsonProcessingException {

		final var header = new BaseHeader();
		header.setTraceNumber(CommonUtil.generate(TDBService.PREFIX, TDBService.DATE_PATTERN, 3));
		header.setCreatedDate(new Date());
		header.setServiceCode(TDBConstants.BALANCE_INQUIRY);

		final var iden = new OrgId();
		iden.setAnyBIC(apiRequest.getOrgId());
		final var orgId = new Id();
		orgId.setOrgId(iden);
		final var org = new InitgPty();
		org.setId(orgId);
		header.setOrganization(org);

		final var creds = new BaseCredentials();
		creds.setLanguage(0);
		creds.setLoginId(apiRequest.getLoginId());

		final var pwds = new Passwords();
		pwds.setPass(apiRequest.getPassword());
		pwds.setPassType(1);
		creds.setPasswords(List.of(pwds));

		header.setCredentials(creds);

		final var balanceInfo = new BalanceInfo();
		balanceInfo.setAccountNumber(apiRequest.getAccountNumber());
		balanceInfo.setCurrency(apiRequest.getCurrency());

		final var req = new BalanceRequest();
		req.setHeader(header);
		req.setBalanceInfo(balanceInfo);

		final var body = this.xmlMapper.writeValueAsString(req);
		final var headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_XML);

		final HttpEntity<?> entity = new HttpEntity<>(body, headers);
		final var response =
				this.restTemplate.exchange(
						this.tdbGatewayProperties.getUrl(), HttpMethod.POST, entity, String.class);

		return this.xmlMapper.readValue(response.getBody(), BalanceResponse.class);
	}

	public ApiPaymentResponse transfer(final ApiPaymentRequest request)
			throws JsonProcessingException {


		final var tdbPayment = new TDBPayment();
		tdbPayment.setBatchCount(1);
		tdbPayment.setTotalAmount(request.getTotalAmount());
		tdbPayment.setImportantAmount("F");
		tdbPayment.setDebtor(new Debtor("TDB-NEHEMJLEGCH-DANSNII-NER"));
		tdbPayment.setDebtorAccount(
				new DebtorAccount(
						new DebtorAccountWrapper("TDB-NEHEMJLEGCH-DANSNII-DUGAAR"),
						"TDB-NEHEMJLEGCH-DANSNII-CURRENCY"));

		// [Read] - Receiver
		final var creditTransfer = new CreditTransfer();
		creditTransfer.setAmount(new CreditAmount(request.getTotalAmount()));
		creditTransfer.setReceiver(new CreditReceiver(request.getReceiverName()));
		creditTransfer.setReceiverAccount(
				new CreditReceiverAccount(
						new ReceiverAccountWrapper(request.getReceiverAccount()),
						request.getReceiverCurrency()));
		creditTransfer.setReceiverBank(
				new ReceiverBank(new ReceiverBankIdentification(request.getReceiverBankCode())));
		creditTransfer.setTransactionDescription(new TransactionDescription(request.getDescription()));

		tdbPayment.setCreditTransfer(creditTransfer);

		final var req = new TDBPaymentTransaction();
		req.setHeader(this.buildTransactionHeader(request.getTotalAmount(), 1, request.isInterTransfer()));
		req.setPayment(tdbPayment);

		final var body = this.xmlMapper.writeValueAsString(req);
		final var headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_XML);

		final HttpEntity<?> entity = new HttpEntity<>(body, headers);
		final var response =
				this.restTemplate.exchange(
						this.tdbGatewayProperties.getUrl(), HttpMethod.POST, entity, String.class);

		return new ApiPaymentResponse(
				this.xmlMapper.readValue(response.getBody(), TDBPaymentResponse.class), body);
	}

	private TransferHeader buildTransactionHeader(
			final BigDecimal totalAmount, final Integer batchCount, final boolean isInterTransfer) {

		final var header = new TransferHeader();
		header.setTraceNumber(CommonUtil.generate(TDBService.PREFIX, TDBService.DATE_PATTERN, 3));
		header.setCreatedDate(new Date());

		if(isInterTransfer) {
			header.setServiceCode(TDBConstants.INTER_BANK_TRANSFER);
		} else {
			header.setServiceCode(TDBConstants.INTRA_BANK_TRANSFER);
		}

		header.setBatchCount(batchCount);
		header.setAmountSum(totalAmount);

		final var iden = new OrgId();
		iden.setAnyBIC("TDB-ORG-ID");
		final var orgId = new Id();
		orgId.setOrgId(iden);
		final var org = new InitgPty();
		org.setId(orgId);
		header.setOrganization(org);

		final var creds = new BaseCredentials();
		creds.setLanguage(0);
		creds.setLoginId("TDB-LOGIN-ID");

		final var firstPassword = new Passwords();
		firstPassword.setPass("TDB-FIRST-PASS");
		firstPassword.setPassType(1);

		final var secondPassword = new Passwords();
		secondPassword.setPass("TDB-SECOND-PASS");
		secondPassword.setPassType(2);

		creds.setPasswords(List.of(firstPassword, secondPassword));

		header.setCredentials(creds);
		return header;
	}
}
