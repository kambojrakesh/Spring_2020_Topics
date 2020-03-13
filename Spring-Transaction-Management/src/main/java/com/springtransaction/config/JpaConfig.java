
package com.springtransaction.config;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 
@Configuration
@EnableJpaRepositories(basePackages = "com.springtransaction.repository")
public class JpaConfig {
 
}