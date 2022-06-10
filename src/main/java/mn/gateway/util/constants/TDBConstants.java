package mn.gateway.util.constants;

public class TDBConstants {

  private TDBConstants() {}

  public static final Integer INTRA_BANK_TRANSFER = 1001;
  public static final Integer INTER_BANK_TRANSFER = 1002;
  public static final Integer INTERNATIONAL_TRANSFER = 1003;
  public static final Integer BATCH_TRANSACTION = 1004;
  public static final Integer SALARY_BATCH_TRANSACTION = 1005;

  public static final Integer BATCH_TRANSACTION_INQUIRY = 5001;
  public static final Integer BATCH_TRANSACTION_INQUIRY_DETAIL = 5002;
  public static final Integer BALANCE_INQUIRY = 5003;
  public static final Integer STATEMENT = 5004;

  public static final Integer COUNTRY = 7001;
  public static final Integer BANK = 7002;
  public static final Integer CURRENCY = 7003;
  public static final Integer RATE = 7004;

  public static final Integer CODE_SUCCESS = 10;
  public static final Integer CODE_PENDING = 11;
  public static final Integer CODE_BATCH_START_SUCCESS = 12;
  public static final Integer CODE_FIRST_STEP_SUCCESS = 13;

  public static final Integer CODE_INCORRECT_HEADER = 51;
  public static final Integer CODE_INCORRECT_BODY = 52;
  public static final Integer CODE_INCORRECT_AUTH = 53;
  public static final Integer CODE_INCORRECT_TRANS_CODE = 54;
  public static final Integer CODE_ACCOUNT_NOT_FOUND = 55;
  public static final Integer CODE_INCORRECT_ACCOUNT_NAME = 56;
  public static final Integer CODE_INSUFFICIENT_FUND = 57;
  public static final Integer CODE_TRACE_ERROR = 60;
  public static final Integer CODE_TRANS_ERROR_2 = 61;
  public static final Integer CODE_TRANS_ERROR_3 = 62;
  public static final Integer CODE_TRACE_DUPLICATE = 98;
  public static final Integer CODE_OTHER = 99;
}
