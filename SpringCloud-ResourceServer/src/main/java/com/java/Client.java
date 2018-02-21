package com.java;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableResourceServer
@RestController
public class Client {

	
	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);

	}
	
	@GetMapping("/accounts")
	private List<Account> getAccountDetails(){
		return Arrays.asList(new Account(1, 3443.33f),new Account(2, 343434.33f));
	}
	
	
}
