package com.example.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.dao.UserRepository;
import com.java.dto.Users;

@Service
public class UserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> optionalUsers= repository.findByName(username);
		optionalUsers.orElseThrow(()->new UsernameNotFoundException("No such user exist in the db"));
		return optionalUsers.map(CustomUserDetails::new).get();
	}

}
