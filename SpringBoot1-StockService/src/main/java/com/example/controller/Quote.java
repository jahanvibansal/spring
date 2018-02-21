package com.example.controller;

import java.math.BigDecimal;

public class Quote {
	
	private String quote;
	private BigDecimal price;
	public Quote(String quote2, BigDecimal price2) {
		this.price= price2;
		this.quote= quote2;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	

}
