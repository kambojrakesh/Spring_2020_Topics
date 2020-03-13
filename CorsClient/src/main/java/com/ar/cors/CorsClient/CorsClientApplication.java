package com.ar.cors.CorsClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@ComponentScan("com.ar.cors")
@SpringBootApplication
public class CorsClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorsClientApplication.class, args);
		System.out.println("client started.");
//		callMyApi();
	}
	
//	public static void callMyApi() {
//		final String uri = "http://localhost:8080/cors/students";
//	    RestTemplate restTemplate = new RestTemplate();
//	    String result = restTemplate.getForObject(uri, String.class);
//	    System.out.println(result);
//	}
}
