package mn.gateway.model.payment;

public enum PaymentType {
	QPAY("QPAY", "QPAY"),
	HHB("HHB", "Дансаар"),
	MANUAL("MANUAL", "Систем"),
	IN_APP_PURCHASE("IN_APP_PURCHASE", "Апп доторх худалдан авалт");

	final String value;
	final String description;

	PaymentType(final String value, final String description) {
		this.value = value;
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public String getValue() {
		return this.value;
	}
}
