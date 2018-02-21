package com.java.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableZuulProxy
@RestController
public class ConsumerClient {

	@Autowired
	shoppingService service;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerClient.class, args);
		

	}
	@RequestMapping("/cust")
	private String getCustomers() {
		return service.getCustomers();
	}
	
	/*@RequestMapping("/cart")
	private String getCart() {
		return service.getCustomers();
	}*/
	@FeignClient("shopping")
	static interface shoppingService {
		@RequestMapping("/Customers")
		public String getCustomers() ;
		
	}

	
}
