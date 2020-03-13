package com.example.SpringLogging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class AppConfig {
	
	 @Bean
	 public CommonsRequestLoggingFilter commonsRequestLoggingFilter() {
	        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
	        filter.setIncludeQueryString(true);
	        filter.setIncludePayload(true);
	        filter.setMaxPayloadLength(10000);
	        filter.setIncludeHeaders(false);
	        filter.setAfterMessagePrefix("AFTER REQUEST : ");
	        return filter;
	    } 

}
