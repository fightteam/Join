package org.fightteam.join.samples.rest;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import org.fightteam.join.samples.rest.data.MyCustomModule;
import org.fightteam.join.samples.rest.data.MyEntityDeserializer;
import org.fightteam.join.samples.rest.data.MyEntitySerializer;
import org.fightteam.join.samples.rest.data.PersistentEntityJackson2Module;
import org.fightteam.join.samples.rest.data.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* [description]
*
* @author faith
* @since 0.0.1
*/
@Configuration
public class RestExporterExampleRestConfig extends RepositoryRestMvcConfiguration {


    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.setDefaultMediaType(MediaType.APPLICATION_JSON);
    }

    @Bean
    @Override
    public MappingJackson2HttpMessageConverter jacksonHttpMessageConverter() {

        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.addAll(Arrays.asList(MediaType.valueOf("application/json")));


        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
        jacksonConverter.setObjectMapper(objectMapper());
        jacksonConverter.setSupportedMediaTypes(mediaTypes);

        return jacksonConverter;
    }

    @Override
    protected void configureJacksonObjectMapper(ObjectMapper objectMapper) {



    }

    @Bean
    public Module persistentEntityJackson2Module() {
        PersistentEntityJackson2Module module = new PersistentEntityJackson2Module(resourceMappings(), defaultConversionService());
        module.addSerializer(User.class, new MyEntitySerializer());
        return module;
    }

}
