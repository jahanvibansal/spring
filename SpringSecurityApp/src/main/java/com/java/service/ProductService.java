package com.java.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.dao.ProductRepository;
import com.java.dto.Category;
import com.java.dto.Product;

@RestController

public class ProductService {

	@Autowired
	ProductRepository repository;

	@PostConstruct
	public void populate() {

		Product product1 = new Product();
		product1.setProductId(1984);
		product1.setCategory(Category.BOOKS);
		product1.setPrice(4634.33);

		Product product2 = new Product();
		product2.setProductId(4343);
		product2.setCategory(Category.APPLIANCES);
		product2.setPrice(476473);
		repository.save(product1);
		repository.save(product2);
	}

	@GetMapping("/Products")
	@ResponseBody
	public List<Product> getProducts() {
		return repository.findAll();
	}
}
