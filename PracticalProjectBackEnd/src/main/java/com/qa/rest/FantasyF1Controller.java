package com.qa.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.entity.FantasyF1;
import com.qa.service.FantasyF1Service;

@CrossOrigin
@RestController
public class FantasyF1Controller {

	@Autowired
	private FantasyF1Service service; // dependency

	@GetMapping("/demoFantasyF1")
	public FantasyF1 getDemoFantasyF1() {
		return new FantasyF1("Ridwan Kawsar", "Mercedes", "McLaren", "Charles Leclerc", "Lewis Hamilton");
	}

	@GetMapping("/getFantasyF1/{id}")
	public FantasyF1 getById(@PathVariable int id) {
		return this.service.getById(id);
	}

	@GetMapping("/getFantasyF1")
	public List<FantasyF1> getAll() {
		return this.service.getAll();
	}

	@GetMapping("/getFantasyF1ByTeamPrinciple/{teamPrinciple}")
	public FantasyF1 getFantasyF1ByTeamPrinciple(@PathVariable String teamPrinciple) {
		return this.service.findByTeamPrinciple(teamPrinciple);
	}
	
	@PostMapping("/createFantasyF1")
	public ResponseEntity<FantasyF1> create(@RequestBody FantasyF1 f1) {
		System.out.println("Created: " + f1);
		FantasyF1 created = this.service.create(f1);

		return new ResponseEntity<FantasyF1>(created, HttpStatus.CREATED); // Setting the Status Code 201; Created
	}

	@PatchMapping("/updateFantasyF1/{id}")
	public FantasyF1 update(@PathVariable("id") int id, @PathParam("teamPrinciple") String teamPrinciple,
			@PathParam("engineProvider") String engineProvider, @PathParam("teamName") String teamName,
			@PathParam("driverOne") String driverOne, @PathParam("driverTwo") String driverTwo) {
		return this.service.update(id, teamPrinciple, engineProvider, teamName, driverOne, driverTwo);
	}

	@DeleteMapping("/removeFantasyF1/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}