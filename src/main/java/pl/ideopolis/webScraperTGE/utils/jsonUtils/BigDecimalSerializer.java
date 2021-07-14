package pl.ideopolis.webScraperTGE.utils.jsonUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.ideopolis.webScraperTGE.utils.BigDecimalConvertion;

import java.io.IOException;
import java.math.BigDecimal;

public class BigDecimalSerializer extends JsonSerializer<BigDecimal> {
    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeNumber(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(value));
    }
}
