package org.fightteam.join.samples.security;

import org.fightteam.join.dao.AbstractDataConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Configuration
@EnableJpaRepositories(basePackages = "org.fightteam.join")
@EnableTransactionManagement
public class DataConfig extends AbstractDataConfig {
}
