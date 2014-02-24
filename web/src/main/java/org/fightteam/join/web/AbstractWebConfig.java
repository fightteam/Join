package org.fightteam.join.web;

import org.fightteam.join.AbstractAppConfig;
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
//@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = AbstractAppConfig.class,includeFilters = {@ComponentScan.Filter(Controller.class), @ComponentScan.Filter(ControllerAdvice.class)},
        useDefaultFilters = false)
public class AbstractWebConfig extends WebMvcConfigurerAdapter {

}
