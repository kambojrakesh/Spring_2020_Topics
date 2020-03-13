package com.springtransaction.springtransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = { "com.springtransaction" })
@EntityScan("com.springtransaction.*")
public class SpringMainExample {

	public static void main(final String[] args) {
		SpringApplication.run(SpringMainExample.class, args);

	}

}
