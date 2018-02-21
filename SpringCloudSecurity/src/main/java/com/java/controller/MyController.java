package com.java.controller;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableOAuth2Sso
public class MyController /*extends WebSecurityConfigurerAdapter*/{
	//used to configure patterns we need to validate using github
	@GetMapping("/detail1")
	public String getDetails1() {
		return "Payal1";
	}

	
	@GetMapping("/secureddetail1")
	public String getDetails2() {
		return "Payal2";
	}
	
	
	@GetMapping("/secureddetail2")
	public String getDetails3() {
		return "Payal3";
	}
/*	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/secure**").authenticated().anyRequest().permitAll();
	}*/
}
