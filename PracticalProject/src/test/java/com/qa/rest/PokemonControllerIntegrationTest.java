package com.qa.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.entity.Pokemon;

@SpringBootTest
@AutoConfigureMockMvc // sets up the testing class
@Sql(scripts = { "classpath:pokemon-schema.sql",
		"classpath:pokemon-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class PokemonControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testDemo() throws Exception {
		Pokemon pokemon = new Pokemon(1, "Pikachu", "Electric", "Mouse", 180, 103, 76);
		this.mvc.perform(get("/demoPokemon")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(pokemon)));
	}
	
	@Test
	void testRead() throws Exception {
		List<Pokemon> pokemon = List.of(new Pokemon(1, "Pikachu", "Electric", "Mouse", 180, 103, 76));
		this.mvc.perform(get("/getPokemon")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(pokemon)));
	}

	@Test
	void testReadById() throws Exception {
		Pokemon testPokemonId = new Pokemon(1, "Pikachu", "Electric", "Mouse", 180, 103, 76);
		this.mvc.perform(get("/getPokemonById/1")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(testPokemonId)));
	}

	@Test
	void testReadByName() throws Exception {
		List<Pokemon> testPokemonName = new ArrayList<Pokemon>();
		testPokemonName.add(new Pokemon(1, "Pikachu", "Electric", "Mouse", 180, 103, 76));
		this.mvc.perform(get("/getPokemonByName/Pikachu")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(testPokemonName)));
	}

	@Test
	void testCreate() throws Exception {
		Pokemon testPokemon = new Pokemon("Charizard", "Fire", "Dragon", 266, 155, 144);
		String testPokemonAsJSON = this.mapper.writeValueAsString(testPokemon);
		RequestBuilder req = post("/createPokemon").content(testPokemonAsJSON)
				.contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().is(201);
		Pokemon createdPokemon = new Pokemon(2, "Charizard", "Fire", "Dragon", 266, 155, 144);
		String createdPokemonAsJSON = this.mapper.writeValueAsString(createdPokemon);
		ResultMatcher checkBody = content().json(createdPokemonAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testUpdate() throws Exception {
		Pokemon updated = new Pokemon(1, "Raichu", "Electric", "Mouse", 230, 166, 103);
		this.mvc.perform(patch(
				"/updatePokemon/1?name=Raichu&type=Electric&species=Mouse&health=230&attack=166&defense=103"))
				.andExpect(status().isOk()).andExpect(content().json(this.mapper.writeValueAsString(updated)));
	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/removePokemon/1")).andExpect(status().isNoContent());
	}
}