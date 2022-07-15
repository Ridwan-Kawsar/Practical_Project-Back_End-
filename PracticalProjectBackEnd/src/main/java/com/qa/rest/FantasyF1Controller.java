package com.qa.rest;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.entity.FantasyF1;

@RestController
public class FantasyF1Controller {

	private List<FantasyF1> fantasyf1 = new ArrayList<>();
	
	@GetMapping("/hello")
	public String helloWorld() {
		String a = "Hello, ";
		String b = "World";
		return a + b;
	}

	@GetMapping("/demoFantasyF1")
	public FantasyF1 getDemoFantasyF1() {
		return new FantasyF1("Ridwan Kawsar", "Mercedes", "McLaren", "Charles Leclerc", "Lewis Hamilton");
	}

	@PostMapping("/createFantasyF1")
	public FantasyF1 create(@RequestBody FantasyF1 f1) {
		System.out.println("Created: " + f1);
		this.fantasyf1.add(f1);
		return this.fantasyf1.get(this.fantasyf1.size() -1);
	}
	
	@PatchMapping("/updateFantasyF1{id}")
	public void update(@PathVariable("id") int id, @PathParam("teamPrinciple") String teamPrinciple, @PathParam("engineProvider") String engineProvider, 
			@PathParam("teamName") String teamName, @PathParam("driverOne") String driverOne, @PathParam("driverTwo") String driverTwo){
		System.out.println("ID: " + id);
		System.out.println("Team Principle: " + teamPrinciple);
		System.out.println("Engine Provider: " + engineProvider);
		System.out.println("Team Name: " + teamName);
		System.out.println("Driver 1: " + driverOne);
		System.out.println("Driver 2: " + driverTwo);
	}
	
	// id = 4994
	@DeleteMapping("/removeFantasyF1{id}")
	public void delete(@PathVariable int id) {
		System.out.println("ID: " + id);
	}
}
