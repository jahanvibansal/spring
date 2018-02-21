package com.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	

}
