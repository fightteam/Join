package org.fightteam.join.samples.rest.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.fightteam.join.samples.rest.data.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mapping.*;
import org.springframework.data.mapping.model.BeanWrapper;
import org.springframework.data.rest.core.mapping.ResourceMetadata;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.support.RepositoryLinkBuilder;
import org.springframework.hateoas.Link;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class MyEntitySerializer extends StdSerializer<PersistentEntityResource<User>> {
    private static final Logger log = LoggerFactory.getLogger(MyEntitySerializer.class);

    public MyEntitySerializer() {
        super((Class) PersistentEntityResource.class);
    }

    @Override
    public void serialize(PersistentEntityResource<User> resource, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
        log.debug("Serializing PersistentEntity " + resource.getPersistentEntity());

        User user = resource.getContent();


           try{

            jgen.writeObject(user);

        } catch (IllegalStateException e) {
            throw (IOException) e.getCause();
        }

    }
}
