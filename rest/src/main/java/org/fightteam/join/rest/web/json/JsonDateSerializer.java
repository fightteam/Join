package org.fightteam.join.rest.web.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.DateTime;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class JsonDateSerializer extends JsonSerializer<DateTime> {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");


    @Override
    public void serialize(DateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        System.out.println("-----------------------");

        jgen.writeNumber(value.getMillis());
    }
}
