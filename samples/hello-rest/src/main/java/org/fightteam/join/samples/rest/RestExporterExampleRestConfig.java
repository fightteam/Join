package org.fightteam.join.samples.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
* [description]
*
* @author faith
* @since 0.0.1
*/
@Configuration
public class RestExporterExampleRestConfig extends RepositoryRestMvcConfiguration {


//    @Override
//    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
////        config.getDomainTypesResourceMappingConfiguration()
////                .getResourceMappingFor(User.class)
////                .getResourceMappingFor("username").setExported(false);
//    }


//    @Override
//    protected void configureJacksonObjectMapper(ObjectMapper objectMapper) {
//        SimpleModule testModule = new SimpleModule("Avlon Module", new Version(1, 0, 0, "","org.fightteam", "jackson-module"));
//
//        testModule.addSerializer(User.class, new MyEntitySerializer());
//        objectMapper.registerModule(testModule);
//        objectMapper.registerModule(new SimpleModule("MyCustomModule"){
//            @Override public void setupModule(SetupContext context) {
//                SimpleSerializers serializers = new SimpleSerializers();
//                SimpleDeserializers deserializers = new SimpleDeserializers();
//
//                serializers.addSerializer(User.class, new MyEntitySerializer());
//
//
//                context.addSerializers(serializers);
//                //context.addDeserializers(deserializers);
//            }
//        });
        //SimpleModule persistentEntityJackson2Module = (SimpleModule)persistentEntityJackson2Module();
       // persistentEntityJackson2Module.addSerializer(User.class, new MyEntitySerializer());
//    }
//    @Override
//    public void setupModule(Module.SetupContext context) {
//        SimpleSerializers serializers = new SimpleSerializers();
//        SimpleDeserializers deserializers = new SimpleDeserializers();
//
//        serializers.addSerializer(User.class, new MyEntitySerializer());
//
//
//        context.addSerializers(serializers);
//        context.addDeserializers(deserializers);
//
//    }


//    @Override
//    protected void configureConversionService(ConfigurableConversionService conversionService) {
//        conversionService.addConverter(new UserCon());
//    }

//    @Override
//    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//        System.out.println("**********************************");
//        System.out.println(config.getDefaultMediaType());
//        config.setDefaultMediaType(MediaType.APPLICATION_JSON);
//        System.out.println("**********************************");
//        System.out.println(config.getDefaultMediaType());
//        //config.getResourceMappingForDomainType(User.class).getResourceMappingFor("username").setExported(false);
////        config.setResourceMappingForDomainType(User.class)
////                .addResourceMappingFor("username").setExported(false);
//
//    }


//    @Bean
//    @Override
//    public RequestMappingHandlerMapping repositoryExporterHandlerMapping() {
//        RepositoryRestHandlerMapping mapping = new RepositoryRestHandlerMapping(resourceMappings(), config());
//        mapping.setJpaHelper(jpaHelper());
//        mapping.setInterceptors(new Object[]{ new CustomInterceptor()});
//        return mapping;
//    }
}
