package com.qa.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.qa.entity.Pokedex;

@SpringBootTest
@AutoConfigureMockMvc // sets up the testing class
@Sql(scripts = { "classpath:pokedex-schema.sql",
		"classpath:pokedex-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class PokedexControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testRead() throws Exception {
		List<Pokedex> pokemon = List.of(new Pokedex(1, "Pikachu", "Electric", "Mouse", 0.4f, 6.0f));
		this.mvc.perform(get("/getPokedex")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(pokemon)));
	}

	@Test
	void testReadById() throws Exception {
		Pokedex testPokedexId = new Pokedex(1, "Pikachu", "Electric", "Mouse", 0.4f, 6.0f);
		this.mvc.perform(get("/getPokedex/1")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(testPokedexId)));
	}

	@Test
	void testReadByName() throws Exception {
		Pokedex testPokedexName = new Pokedex(1, "Pikachu", "Electric", "Mouse", 0.4f, 6.0f);
		this.mvc.perform(get("/getPokedexByName/Pikachu")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(testPokedexName)));
	}

	@Test
	void testCreate() throws Exception {
		Pokedex testPokedex = new Pokedex("Charizard", "Fire", "Dragon", 1.7f, 90.5f);
		String testPokedexAsJSON = this.mapper.writeValueAsString(testPokedex);
		RequestBuilder req = post("/createPokedex").content(testPokedexAsJSON)
				.contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().is(201);
		Pokedex createdPokedex = new Pokedex(2, "Charizard", "Fire", "Dragon", 1.7f, 90.5f);
		String createdPokedexAsJSON = this.mapper.writeValueAsString(createdPokedex);
		ResultMatcher checkBody = content().json(createdPokedexAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testUpdate() throws Exception {
		Pokedex updated = new Pokedex(1, "Raichu", "Electric", "Mouse", 0.8f, 30.0f);
		this.mvc.perform(patch(
				"/updatePokedex/1?name=Raichu&type=Electric&species=Mouse&height=0.8f&weight=30.0f"))
				.andExpect(status().isOk()).andExpect(content().json(this.mapper.writeValueAsString(updated)));
	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/removePokedex/1")).andExpect(status().isNoContent());
	}
}