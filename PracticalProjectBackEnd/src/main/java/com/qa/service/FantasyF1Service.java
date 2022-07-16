package com.qa.service;

import java.util.List;

import com.qa.entity.FantasyF1;

public interface FantasyF1Service {

	FantasyF1 getById(int id);
	
	List<FantasyF1> getAll();

	FantasyF1 findByTeamPrinciple(String teamPrinciple);

	FantasyF1 create(FantasyF1 f1);

	FantasyF1 update(int id, String teamPrinciple, String engineProvider, String teamName, String driverOne, String driverTwo);

	void delete(int id);
		
}