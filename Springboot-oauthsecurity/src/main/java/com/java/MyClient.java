package com.java;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.java.dao.CustomUserDetails;
import com.java.dao.UserRepository;
import com.java.model.Role;
import com.java.model.User;

@SpringBootApplication
public class MyClient {

	public static void main(String[] args) {
		SpringApplication.run(MyClient.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder,UserRepository repo) throws Exception {
		
			repo.save(new User("user1","user1",Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
		builder.userDetailsService(new UserDetailsService() {
			
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return new CustomUserDetails(repo.findByUsername(username));
			}
		});
	}
}
