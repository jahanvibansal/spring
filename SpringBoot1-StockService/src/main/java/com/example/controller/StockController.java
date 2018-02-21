package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@RestController
@RequestMapping("/rest/stock")
public class StockController {

	@Autowired
	RestTemplate template;
	
	@GetMapping("/{username}")
	@HystrixCommand(fallbackMethod="defaultQuotes", commandProperties= {
			@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="60000"),
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="5")
	})
	public List<Quote> getStockQuotes(@PathVariable("username")String name){
		ResponseEntity<List<String>> response= template.exchange("http://db-service/app/students/"+name+"/quote", HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
		});
		List<String> quotes= response.getBody();
	 	return quotes.stream().map(quote->{
			Stock stock= getStock(quote);
			return new Quote(quote, stock.getQuote()!= null?stock.getQuote().getPrice():null);
		}).collect(Collectors.toList());
	}
	
	
	public List<Quote> defaultQuotes(String name){
		//Can get data from backup db: old data.
		List<Quote> quotes= new ArrayList<>();
		return quotes;
	}

	private Stock getStock(String quote) {
		try {
			return YahooFinance.get(quote);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return new Stock(quote);
		}
	}
}
