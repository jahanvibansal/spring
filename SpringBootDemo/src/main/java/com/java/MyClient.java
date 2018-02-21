package com.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyClient {


	
	public static void main(String[] args) {
		Map<String,Integer> map= new HashMap<String, Integer>();
		new Thread(new MyTask1(map)).start();
		new Thread(new MyTask2(map)).start();
		new Thread(new MyTask3(map)).start();
		new Thread(new MyTask4(map)).start();
		new Thread(new MyTask5(map)).start();
		
		map.keySet().stream().forEach(System.out::println);
		/*ConfigurableApplicationContext context= SpringApplication.run(MyClient.class, args);
		StudentController ctrl= context.getBean("studentController", StudentController.class);
		System.out.println(ctrl);*/
		
	}
	
	

}

class MyTask1 implements Runnable{

	Map<String, Integer> map;
	MyTask1(Map<String, Integer> map){
		this.map=map;
	}
	@Override
	public void run() {
		map.put("One", 1);
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
class MyTask2 implements Runnable{

	Map<String, Integer> map;
	MyTask2(Map<String, Integer> map){
		this.map=map;
	}
	@Override
	public void run() {
		map.put("Two", 2);
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class MyTask3 implements Runnable{

	Map<String, Integer> map;
	MyTask3(Map<String, Integer> map){
		this.map=map;
	}
	@Override
	public void run() {
		map.put("THree", 3);
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class MyTask4 implements Runnable{

	Map<String, Integer> map;
	MyTask4(Map<String, Integer> map){
		this.map=map;
	}
	@Override
	public void run() {
		map.put("Four", 4);
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class MyTask5 implements Runnable{

	Map<String, Integer> map;
	MyTask5(Map<String, Integer> map){
		this.map=map;
	}
	@Override
	public void run() {
		map.put("Five", 5);
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


