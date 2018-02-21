package com.java.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.dao.CustomerRepository;
import com.java.dto.Category;
import com.java.dto.Customer;
import com.java.dto.Product;

@RestController

public class CustomerService {
	
	@Autowired
	CustomerRepository repository;

	@PostConstruct
	public void populate() {

		Customer customer1 = new Customer();
		customer1.setId(1001);
		customer1.setName("Payal");
		customer1.setEmail("Payal_bnsl@yahoo.co.in");
		
		Customer customer2 = new Customer();
		customer2.setId(1002);
		customer2.setName("Richa");
		customer2.setEmail("Richa_narayana@yahoo.co.in");
		
		repository.save(customer1);
		repository.save(customer2);
	}

	
	@RequestMapping("/Customers")
	@ResponseBody
	public List<Customer> getCustomers() {
		return repository.findAll();
	}
}
