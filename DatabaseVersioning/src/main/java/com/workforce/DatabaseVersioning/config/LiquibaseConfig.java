package com.workforce.DatabaseVersioning.config;


import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfig {


    @Value("${url}")
    String url;

    @Value("${password}")
    String password;

    @Value("${driver}")
    String driver;

    @Bean
    @Primary
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .url(url)
                .username("sa")
                .password(password)
                .driverClassName(driver)
                .build();
    }

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource, LiquibaseProperties liquibaseProperties){
        SpringLiquibase springLiquibase=new SpringLiquibase();
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setChangeLog("classpath:db-changelog.xml");
        springLiquibase.setContexts(liquibaseProperties.getContexts());
        return springLiquibase;
    }
}
