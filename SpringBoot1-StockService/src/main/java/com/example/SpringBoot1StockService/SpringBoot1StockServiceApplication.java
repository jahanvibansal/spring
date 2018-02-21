package com.example.SpringBoot1StockService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

import com.example.config.TemplateConfig;
import com.example.controller.StockController;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@ComponentScan(basePackageClasses= {StockController.class, TemplateConfig.class})
public class SpringBoot1StockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot1StockServiceApplication.class, args);
	}
}
