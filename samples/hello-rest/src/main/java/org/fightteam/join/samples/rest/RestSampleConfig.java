package org.fightteam.join.samples.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Configuration
public class RestSampleConfig extends RepositoryRestMvcConfiguration {

//    @Override
//    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//        config.setDefaultMediaType(MediaType.APPLICATION_JSON);
//
//    }


//    @Bean
//    @Override
//    public MappingJackson2HttpMessageConverter jacksonHttpMessageConverter() {
//
//        List<MediaType> mediaTypes = new ArrayList<MediaType>();
//        mediaTypes.addAll(Arrays.asList(MediaType.valueOf("application/json")));
//
//
//        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
//        jacksonConverter.setObjectMapper(objectMapper());
//        jacksonConverter.setSupportedMediaTypes(mediaTypes);
//
//        return jacksonConverter;
//    }
//
//    @Override
//    protected void configureJacksonObjectMapper(ObjectMapper objectMapper) {
//
//
//       // objectMapper.registerModule(new PersistentEntityJackson2SimpleModule(resourceMappings(),config()));
//        objectMapper.registerModule(new SimpleModule("CustomJacksonModule") {
//
//
//            @Override
//            public void setupModule(Module.SetupContext context) {
//                SimpleSerializers simpleSerializers = new SimpleSerializers();
//                simpleSerializers.addSerializer(DateTime.class,new JsonDateSerializer());
//                context.addSerializers(simpleSerializers);
//            }
//        });
//
//    }

//    @Bean
//    @Override
//    public Module persistentEntityJackson2Module() {
//        return new PersistentEntityJackson2SimpleModule(resourceMappings(), defaultConversionService());
//    }



}