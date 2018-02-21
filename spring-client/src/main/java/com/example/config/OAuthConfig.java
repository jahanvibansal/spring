package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//client will decide what authentication to use
@EnableOAuth2Sso
@Configuration
public class OAuthConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AuthenticationManager manager;
	
	// configure endpoints
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().antMatchers("/**").and().authorizeRequests().antMatchers("/","/login**")
				.permitAll().anyRequest().authenticated();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.parentAuthenticationManager(manager).inMemoryAuthentication().withUser("Peter").password("peter")
				.roles("ADMIN");
	}
}
