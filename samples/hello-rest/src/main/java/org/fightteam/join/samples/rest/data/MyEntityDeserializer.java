package org.fightteam.join.samples.rest.data;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.fightteam.join.samples.rest.data.entity.User;

import java.io.IOException;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class MyEntityDeserializer extends JsonDeserializer<User> {
    @Override
    public User deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        System.out.println("==========333333=======");
        return null;
    }
}
