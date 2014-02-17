package org.fightteam.join.samples.rest.data;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.fightteam.join.samples.rest.data.entity.User;

import java.io.IOException;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class MyEntitySerializer extends JsonSerializer<User> {
    @Override
    public void serialize(User value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        System.out.println("***********************************8");
    }
}
