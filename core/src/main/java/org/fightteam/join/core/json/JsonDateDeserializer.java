package org.fightteam.join.core.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.DateTime;

import java.io.IOException;

/**
 * jodaTime json输入格式
 *
 * 以毫秒输入
 *
 * @author excalibur
 * @since 0.0.1
 */
public class JsonDateDeserializer extends JsonDeserializer<DateTime> {

    @Override
    public DateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Long millis = jp.getLongValue();
        DateTime dateTime = new DateTime(millis);
        return dateTime;
    }
}
