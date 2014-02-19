package org.fightteam.join.samples.rest;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import org.fightteam.join.rest.web.json.JsonDateSerializer;
import org.joda.time.DateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
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
public class RestSampleConfig extends RepositoryRestMvcConfiguration {

    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.setDefaultMediaType(MediaType.APPLICATION_JSON);

//        // only for link
//        config.setResourceMappingForDomainType(User.class)
//                .addResourceMappingFor("username").setPath("22222");

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


       // objectMapper.registerModule(new PersistentEntityJackson2SimpleModule(resourceMappings(),config()));
        objectMapper.registerModule(new SimpleModule("CustomJacksonModule") {


            @Override
            public void setupModule(Module.SetupContext context) {
                SimpleSerializers simpleSerializers = new SimpleSerializers();
                simpleSerializers.addSerializer(DateTime.class,new JsonDateSerializer());
                context.addSerializers(simpleSerializers);
            }
        });

    }

//    @Bean
//    @Override
//    public Module persistentEntityJackson2Module() {
//        return new PersistentEntityJackson2SimpleModule(resourceMappings(), defaultConversionService());
//    }



}