package com.helloworld.ex4HelloWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex4HelloWorldApplication {
	public String Hello() {
		return "Hello World";
	}
	public static void main(String[] args) {
		SpringApplication.run(Ex4HelloWorldApplication.class, args);
		
		Ex4HelloWorldApplication ob = new Ex4HelloWorldApplication();
    	
        System.out.println(ob.Hello());
	}

}
