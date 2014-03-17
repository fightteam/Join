package org.fightteam.join.samples.security;

import org.fightteam.join.AbstractAppConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Configuration
@ComponentScan(basePackages = "org.fightteam.join")
@PropertySource(value = "classpath:app.properties")
@EnableAsync
public class AppConfig extends AbstractAppConfig {
}
