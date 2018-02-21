package com.java.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.Users;


public interface UserRepository extends JpaRepository<Users, Integer>{

	public Optional<Users> findByName(String username);
	

}
