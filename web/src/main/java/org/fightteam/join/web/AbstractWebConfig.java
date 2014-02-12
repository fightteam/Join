package org.fightteam.join.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于java config的spring mvc配置
 *
 * spring framework 4.0
 *
 * 只扫描spring mvc的注解
 *
 * @author excalibur
 * @since 0.0.1
 */
@Configuration
@EnableWebMvc
@ComponentScan(includeFilters = {@ComponentScan.Filter(Controller.class), @ComponentScan.Filter(ControllerAdvice.class)},
        useDefaultFilters = false)
public abstract class AbstractWebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        Map<String, MediaType> map = new HashMap<>();
        map.put("json",MediaType.APPLICATION_JSON);
        map.put("xml",MediaType.APPLICATION_XML);
        configurer.favorPathExtension(false)
                .favorParameter(true).mediaTypes(map);
    }

//    @Bean
//    public InternalResourceViewResolver getInternalResourceViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setOrder(2);
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index");
//    }
}
