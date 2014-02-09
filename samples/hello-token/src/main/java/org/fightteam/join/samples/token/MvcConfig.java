package org.fightteam.join.samples.token;

import org.fightteam.join.web.AbstractWebConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Configuration
@EnableWebMvc
@ComponentScan(excludeFilters = {@ComponentScan.Filter(value = Configuration.class, type = FilterType.ANNOTATION)})
public class MvcConfig extends AbstractWebConfig {
}
