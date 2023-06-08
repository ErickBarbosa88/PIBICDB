package com.aos.aplicacaospring.aos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.aos.aplicacaospring.aos.model")
public class AosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AosApplication.class, args);
	}

}
