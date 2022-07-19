package com.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.rest.FantasyF1Controller;

@SpringBootApplication
public class PracticalProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PracticalProjectApplication.class, args);
		System.out.println("Found the bean: " + context.getBean(FantasyF1Controller.class));
	}

}