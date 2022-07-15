package com.qa.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Table
public class FantasyF1Team {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Integer id;

	@Column(name = "fantasyTeam", nullable = false, unique = true)
	private String teamPrinciple;
	private String engineProvider;
	private String teamName;
	private String driverOne;
	private String driverTwo;

	public FantasyF1Team() {
		super();
		// REQUIRED
	}

	public FantasyF1Team(String teamPrinciple, String engineProvider, String teamName, String driverOne,
			String driverTwo) {
		super();
		this.teamPrinciple = teamPrinciple;
		this.engineProvider = engineProvider;
		this.teamName = teamName;
		this.driverOne = driverOne;
		this.driverTwo = driverTwo;
	}

	public FantasyF1Team(Integer id, String teamPrinciple, String engineProvider, String teamName, String driverOne,
			String driverTwo) {
		super();
		this.id = id;
		this.teamPrinciple = teamPrinciple;
		this.engineProvider = engineProvider;
		this.teamName = teamName;
		this.driverOne = driverOne;
		this.driverTwo = driverTwo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeamPrinciple() {
		return teamPrinciple;
	}

	public void setTeamPrinciple(String teamPrinciple) {
		this.teamPrinciple = teamPrinciple;
	}

	public String getEngineProvider() {
		return engineProvider;
	}

	public void setEngineProvider(String engineProvider) {
		this.engineProvider = engineProvider;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getDriverOne() {
		return driverOne;
	}

	public void setDriverOne(String driverOne) {
		this.driverOne = driverOne;
	}

	public String getDriverTwo() {
		return driverTwo;
	}

	public void setDriverTwo(String driverTwo) {
		this.driverTwo = driverTwo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(driverOne, driverTwo, engineProvider, id, teamName, teamPrinciple);
	}

	@Override
	public String toString() {
		return "FantasyF1Team [id=" + id + ", teamPrinciple=" + teamPrinciple + ", engineProvider=" + engineProvider
				+ ", teamName=" + teamName + ", driverOne=" + driverOne + ", driverTwo=" + driverTwo + "]";
	}

}