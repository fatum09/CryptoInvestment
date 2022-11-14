package com.crypto.investment.CryptoInvestment.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Slf4j
@Configuration
@Profile("jdbcdev")
//@PropertySource({"classpath:application.properties","classpath:application-jdbcdev.properties"})
@PropertySource({"classpath:application-jdbcdev.properties"})
public class DBConfig {

    @Autowired
    Environment environment;

    private final String DRIVER = "spring.datasource.driverClassName";
    private final String URL = "spring.datasource.url";
    private final String USER = "spring.datasource.username";
    private final String PASSWORD = "spring.datasource.password";

    @Bean(name = "ds_jdbc")
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getProperty(URL));
        driverManagerDataSource.setUsername(environment.getProperty(USER));
        driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
        driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
        return driverManagerDataSource;
    }

//    @Bean
//    public JdbcTemplate jdbcTemplate(@Qualifier("ds_jdbc") DataSource dataSource) {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(dataSource);
//        return jdbcTemplate;
//    }

    @PostConstruct
    public void afterPropertySet() {
        log.info("DataSource created");
        log.info("DataSource DRIVER - {}", DRIVER);
        log.info("DataSource URL - {}", URL);
        log.info("DataSource environment.getProperty(URL) - {}", environment.getProperty(URL));
        log.info("DataSource USER - {}", USER);
        log.info("DataSource environment.getProperty(USER) - {}", environment.getProperty(USER));
        log.info("DataSource PASSWORD - {}", PASSWORD);
        log.info("DataSource environment.getProperty(PASSWORD) - {}", environment.getProperty(PASSWORD));
    }
}
