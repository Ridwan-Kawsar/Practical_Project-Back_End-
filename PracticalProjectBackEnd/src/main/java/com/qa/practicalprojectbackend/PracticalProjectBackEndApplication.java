package com.qa.practicalprojectbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.rest.FantasyF1Controller;

@SpringBootApplication
public class PracticalProjectBackEndApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PracticalProjectBackEndApplication.class, args);
		System.out.println("Found the bean: " + context.getBean(FantasyF1Controller.class));
	}

}