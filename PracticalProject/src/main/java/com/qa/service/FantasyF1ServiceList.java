//package com.qa.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.qa.entity.FantasyF1;
//
//@Service
//public class FantasyF1ServiceList implements FantasyF1Service {
//
//	private List<FantasyF1> fantasyf1 = new ArrayList<>();
//
//	@Override
//	public FantasyF1 getById(int id) {
//		return this.fantasyf1.get(id);
//	}
//
//	@Override
//	public List<FantasyF1> getAll() {
//		return this.fantasyf1;
//	}
//
//	@Override
//	public FantasyF1 create(FantasyF1 f1) {
//		this.fantasyf1.add(f1);
//		return this.fantasyf1.get(this.fantasyf1.size() - 1);
//	}
//
//	@Override
//	public FantasyF1 update(int id, String teamPrinciple, String engineProvider, String teamName, String driverOne,
//			String driverTwo) {
//		FantasyF1 toUpdate = this.fantasyf1.get(id);
//		if (teamPrinciple != null)
//			toUpdate.setTeamPrinciple(teamPrinciple);
//		if (engineProvider != null)
//			toUpdate.setEngineProvider(engineProvider);
//		if (teamName != null)
//			toUpdate.setTeamName(teamName);
//		if (driverOne != null)
//			toUpdate.setDriverOne(driverOne);
//		if (driverTwo != null)
//			toUpdate.setDriverTwo(driverTwo);
//		return toUpdate;
//	}
//
//	@Override
//	public void delete(int id) {
//		this.fantasyf1.remove(id);
//	}
//
//	@Override
//	public FantasyF1 findByTeamPrinciple(String teamPrinciple) {
//		return null;
//	}
//}