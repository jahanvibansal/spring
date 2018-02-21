package com.java.client;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableConfigServer
public class MyStarter {

	@Autowired
	static Prop prop;
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(MyStarter.class, args);
		//StudentRepository ob=ctx.getBean("studentRepostiory", StudentRepository.class);
		//System.out.println(ob);
		System.out.println(prop.getUrl());
		
	//	Arrays.stream(ctx.getEnvironment().getActiveProfiles()).forEach(System.out::println);
		
	}

}

@Component
@ConfigurationProperties(prefix="spring.datasource")
class Prop{
	@Value("${url}")
	 String url;

	public  String getUrl() {
		return url;
	}

	public  void setUrl(String url) {
		this.url = url;
	}
	
}
