package com.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/privateResource")
	public String getString() {
		return "protected string";
	}

	@GetMapping("/resource")
	public String getString1() {
		return "hello";
	}
}
