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

import com.qa.entity.Pokemon;
import com.qa.service.PokemonService;

@CrossOrigin
@RestController
public class PokemonController {

	@Autowired
	private PokemonService service; // dependency

	@GetMapping("/demoPokemon")
	public Pokemon getDemoPokemon() {
		return new Pokemon(1, "Pikachu", "Electric", "Mouse", 180, 103, 76);
	}

	@GetMapping("/getPokemon")
	public List<Pokemon> getAll() {
		return this.service.getAll();
	}
	
	@GetMapping("/getPokemonById/{id}")
	public Pokemon getPokemonById(@PathVariable int id) {
		return this.service.getById(id);
	}

	@GetMapping("/getPokemonByName/{name}")
	public List<Pokemon> getPokemonByName(@PathVariable String name) {
		return this.service.findByName(name);
	}
	
	@PostMapping("/createPokemon")
	public ResponseEntity<Pokemon> create(@RequestBody Pokemon pokemon) {
		System.out.println("Created: " + pokemon);
		Pokemon created = this.service.create(pokemon);

		return new ResponseEntity<Pokemon>(created, HttpStatus.CREATED); // Setting the Status Code 201; Created
	}

	@PatchMapping("/updatePokemon/{id}")
	public Pokemon update(@PathVariable("id") int id, @PathParam("name") String name,
			@PathParam("type") String type, @PathParam("species") String species,
			@PathParam("health") Integer health, @PathParam("attack") Integer attack, @PathParam("defense") Integer defense) {
		return this.service.update(id, name, type, species, health, attack, defense);
	}

	@DeleteMapping("/removePokemon/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}