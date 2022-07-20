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

import com.qa.entity.Pokedex;
import com.qa.service.PokedexService;

@CrossOrigin
@RestController
public class PokedexController {

	@Autowired
	private PokedexService service; // dependency

//	@GetMapping("/demoPokedex")
//	public Pokedex getDemoPokedex() {
//		return new Pokedex(1, "Pikachu", "Electric", "Mouse", 0.4f, 6.0f);
//	}

	@GetMapping("/getPokedex")
	public List<Pokedex> getAll() {
		return this.service.getAll();
	}
	
	@GetMapping("/getPokedex/{id}")
	public Pokedex getById(@PathVariable int id) {
		return this.service.getById(id);
	}

	@GetMapping("/getPokedexByName/{name}")
	public Pokedex getPokedexByName(@PathVariable String name) {
		return this.service.findByName(name);
	}
	
	@PostMapping("/createPokedex")
	public ResponseEntity<Pokedex> create(@RequestBody Pokedex pokemon) {
		System.out.println("Created: " + pokemon);
		Pokedex created = this.service.create(pokemon);

		return new ResponseEntity<Pokedex>(created, HttpStatus.CREATED); // Setting the Status Code 201; Created
	}

	@PatchMapping("/updatePokedex/{id}")
	public Pokedex update(@PathVariable("id") int id, @PathParam("name") String name,
			@PathParam("type") String type, @PathParam("species") String species,
			@PathParam("height") Float height, @PathParam("weight") Float weight) {
		return this.service.update(id, name, type, species, height, weight);
	}

	@DeleteMapping("/removePokedex/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}