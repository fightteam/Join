package org.fightteam.join.test.config;

import org.fightteam.join.dao.AbstractDataConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.vendor.Database;

import javax.sql.DataSource;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class TestDataConfig extends AbstractDataConfig {
    private final static Logger log = LoggerFactory.getLogger(TestDataConfig.class);

    @Bean
    @Override
    public DataSource dataSource() {
        setDatabaseType(Database.HSQL);
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL).build();
    }

}
