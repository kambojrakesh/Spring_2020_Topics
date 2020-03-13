package com.workforce.DatabaseVersioning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = "com.workforce.DatabaseVersioning")
@EnableConfigurationProperties({LiquibaseProperties.class})
public class DatabaseVersioningApp {

    public static void main(String[] args){
        SpringApplication.run(DatabaseVersioningApp.class,args);
    }
}
