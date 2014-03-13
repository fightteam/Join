package org.fightteam.join.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * 数据源配置
 *
 * @author faith
 * @since 0.0.1
 */
public abstract class AbstractDataConfig {

    private final static Logger log = LoggerFactory.getLogger(AbstractDataConfig.class);

    private Database databaseType = Database.MYSQL;

    private String packagesToScanPath = "org.fightteam";

    private String envContextName = "java:/comp/env";

    private String lookupName = "jdbc/database";

    private boolean generateDdl = true;

    @Bean
    public DataSource dataSource() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup(getEnvContextName());
            DataSource ds = (DataSource) envContext.lookup(getLookupName());
            return ds;
        } catch (NamingException e) {
            log.error("create data source error", e);
        }
        return null;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        vendorAdapter.setDatabase(getDatabaseType());
        vendorAdapter.setGenerateDdl(isGenerateDdl());

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(getPackagesToScanPath());
        factory.setDataSource(dataSource());

        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public JpaDialect jpaDialect() {
        return new HibernateJpaDialect();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    public String getPackagesToScanPath() {
        return packagesToScanPath;
    }

    public void setPackagesToScanPath(String packagesToScanPath) {
        this.packagesToScanPath = packagesToScanPath;
    }

    public String getEnvContextName() {
        return envContextName;
    }

    public void setEnvContextName(String envContextName) {
        this.envContextName = envContextName;
    }

    public String getLookupName() {
        return lookupName;
    }

    public void setLookupName(String lookupName) {
        this.lookupName = lookupName;
    }

    public Database getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(Database databaseType) {
        this.databaseType = databaseType;
    }

    public boolean isGenerateDdl() {
        return generateDdl;
    }

    public void setGenerateDdl(boolean generateDdl) {
        this.generateDdl = generateDdl;
    }
}
