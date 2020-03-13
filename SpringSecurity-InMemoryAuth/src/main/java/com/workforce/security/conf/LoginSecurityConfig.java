package com.workforce.security.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
               @EnableWebSecurity
               @EnableGlobalMethodSecurity(prePostEnabled=true)
               public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

                              @Autowired
                              public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
                                             //PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
                                             authenticationMgr.inMemoryAuthentication()
                                                            .withUser("dbuser").password("{noop}db").roles("USER")
                                                            .and()
                                                            .withUser("dbadmin").password("{noop}dba@123").roles("USER","ADMIN");
                              }
                              @Override
                              protected void configure(HttpSecurity http) throws Exception {

                                             
                                             http.authorizeRequests()
                                                            .antMatchers("/service/userPage").hasAnyRole("USER", "ADMIN")
                                                            .antMatchers("/service/adminPage").hasRole("ADMIN")
                                                           .and().httpBasic();
}
}
