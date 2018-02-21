package com.java.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages="com.java")
@EnableJpaRepositories(basePackages="com.java.dao")
@EntityScan(basePackages="com.java.dto")
@EnableDiscoveryClient
public class Client1 {

	public static void main(String[] args) {
		SpringApplication.run(Client1.class, args);

	}

}
