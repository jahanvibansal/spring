package com.java.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdConfig {
	
	@Bean("studentRepository")
	public StudentRepository getRepo() {
		return new StudentRepository();
	}

}
