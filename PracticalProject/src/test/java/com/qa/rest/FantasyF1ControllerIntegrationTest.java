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
import com.qa.entity.FantasyF1;

@SpringBootTest
@AutoConfigureMockMvc // sets up the testing class
@Sql(scripts = { "classpath:fantasyf1-schema.sql",
		"classpath:fantasyf1-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class FantasyF1ControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testRead() throws Exception {
		List<FantasyF1> f1 = List
				.of(new FantasyF1(1, "Ridwan Kawsar", "Mercedes", "McLaren", "Charles Leclerc", "Lewis Hamilton"));
		this.mvc.perform(get("/getFantasyF1")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(f1)));
	}

	@Test
	void testReadById() throws Exception {
		FantasyF1 testFantasyF1Id = new FantasyF1(1, "Ridwan Kawsar", "Mercedes", "McLaren", "Charles Leclerc",
				"Lewis Hamilton");
		this.mvc.perform(get("/getFantasyF1/1")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(testFantasyF1Id)));
	}

	@Test
	void testReadByTeamPrinciple() throws Exception {
		FantasyF1 testFantasyF1TeamPrinciple = new FantasyF1(1, "Ridwan Kawsar", "Mercedes", "McLaren",
				"Charles Leclerc", "Lewis Hamilton");
		this.mvc.perform(get("/getFantasyF1ByTeamPrinciple/Ridwan Kawsar")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(testFantasyF1TeamPrinciple)));
	}

	@Test
	void testCreate() throws Exception {
		FantasyF1 testFantasyF1 = new FantasyF1("Saif Hussain", "Honda", "Red Bull", "Max Verstappen",
				"George Russell");
		String testFantasyF1AsJSON = this.mapper.writeValueAsString(testFantasyF1);
		RequestBuilder req = post("/createFantasyF1").content(testFantasyF1AsJSON)
				.contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().is(201);
		FantasyF1 createdFantasyF1 = new FantasyF1(2, "Saif Hussain", "Honda", "Red Bull", "Max Verstappen",
				"George Russell");
		String createdFantasyF1AsJSON = this.mapper.writeValueAsString(createdFantasyF1);
		ResultMatcher checkBody = content().json(createdFantasyF1AsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testUpdate() throws Exception {
		FantasyF1 updated = new FantasyF1(1, "Ridwan Kawsar", "Mercedes", "McLaren", "Lando Norris", "Lewis Hamilton");
		this.mvc.perform(patch(
				"/updateFantasyF1/1?teamPrinciple=Ridwan Kawsar&engineProvider=Mercedes&teamName=McLaren&driverOne=Lando Norris&driverTwo=Lewis Hamilton"))
				.andExpect(status().isOk()).andExpect(content().json(this.mapper.writeValueAsString(updated)));
	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/removeFantasyF1/1")).andExpect(status().isNoContent());
	}
}