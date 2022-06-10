package mn.gateway.model.payment;

public enum PaymentStatus {
	INVOICE_CREATED("INVOICE_CREATED", "Нэхэмжлэл үүсгэсэн"),
	GENIE_TRANSFERED("GENIE_TRANSFERED", "GENIE-д шилжүүлсэн"),
	GENIE_WAITING_TRANSFER("GENIE_WAITING_TRANSFER", "In-App шилжүүлэг, гар аргаар төлөгдөнө"),
	UNPAID("UNPAID", "Төлөгдөөгүй"),
	FAILED("FAILED", "Амжилтгүй"),
	PAID("PAID", "Төлөгдсөн"),
	REFUNDED("REFUNDED", "Буцаагдсан");

	final String value;
	final String description;

	PaymentStatus(final String value, final String description) {
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
