package org.fightteam.join.samples.filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@EnableWebMvc
@ComponentScan(excludeFilters = {@ComponentScan.Filter(value = Configuration.class, type = FilterType.ANNOTATION)})
public class MvcConfig extends WebMvcConfigurerAdapter {
}
