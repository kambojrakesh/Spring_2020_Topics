package com.ar.cors.CrossOrigin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ComponentScan("com.ar.cors")
@SpringBootApplication
public class CrossOriginApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrossOriginApplication.class, args);
		System.out.println("application started.");
	}
	
//	 public WebMvcConfigurer corsConfigurer() {
//	      return new WebMvcConfigurerAdapter() {
//	         @Override
//	         public void addCorsMappings(CorsRegistry registry) {
//	            registry.addMapping("/products").allowedOrigins("http://localhost:8080");
//	         }
//	      };
//	   }
//	public class WebConfig implements WebMvcConfigurer {
//		 
//	    @Override
//	    public void addCorsMappings(CorsRegistry registry) {
//	        registry.addMapping("/students").allowedOrigins("http://localhost:9090").allowedMethods("GET");
//	    }
//	}
}
