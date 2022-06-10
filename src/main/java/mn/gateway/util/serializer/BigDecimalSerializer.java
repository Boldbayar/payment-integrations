package mn.gateway.util.serializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class BigDecimalSerializer extends JsonSerializer<BigDecimal> {
	@Override
	public void serialize(
			final BigDecimal value, final JsonGenerator gen, final SerializerProvider serializerProvider)
					throws IOException {
		if (value != null) {
			gen.writeString(value.setScale(2, RoundingMode.HALF_DOWN) + "");
		} else {
			gen.writeString(value + "");
		}
	}
}
