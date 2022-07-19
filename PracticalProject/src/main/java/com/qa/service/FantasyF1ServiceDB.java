package com.qa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.entity.FantasyF1;
import com.qa.repo.FantasyF1Repo;

@Service
@Primary
public class FantasyF1ServiceDB implements FantasyF1Service {

	@Autowired
	private FantasyF1Repo repo;

	@Override
	public FantasyF1 getById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public List<FantasyF1> getAll() {
		return this.repo.findAll();
	}

	@Override
	public FantasyF1 create(FantasyF1 f1) {
		return this.repo.save(f1);
	}

	@Override
	public FantasyF1 update(int id, String teamPrinciple, String engineProvider, String teamName, String driverOne,
			String driverTwo) {
		FantasyF1 toUpdate = this.getById(id);
		if (teamPrinciple != null)
			toUpdate.setTeamPrinciple(teamPrinciple);
		if (engineProvider != null)
			toUpdate.setEngineProvider(engineProvider);
		if (teamName != null)
			toUpdate.setTeamName(teamName);
		if (driverOne != null)
			toUpdate.setDriverOne(driverOne);
		if (driverTwo != null)
			toUpdate.setDriverTwo(driverTwo);
		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public FantasyF1 findByTeamPrinciple(String teamPrinciple) {
		return this.repo.findByTeamPrincipleStartingWithIgnoreCase(teamPrinciple);
	}

}