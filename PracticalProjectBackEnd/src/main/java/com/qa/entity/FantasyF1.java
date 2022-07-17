package com.qa.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Table
public class FantasyF1 {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Integer id;

	@Column(name = "fantasyTeam", nullable = false, unique = true)
	private String teamPrinciple;
	private String engineProvider;
	private String teamName;
	private String driverOne;
	private String driverTwo;

	public FantasyF1() {
		super();
		// REQUIRED
	}

	public FantasyF1(String teamPrinciple, String engineProvider, String teamName, String driverOne, String driverTwo) {
		super();
		this.teamPrinciple = teamPrinciple;
		this.engineProvider = engineProvider;
		this.teamName = teamName;
		this.driverOne = driverOne;
		this.driverTwo = driverTwo;
	}

	public FantasyF1(Integer id, String teamPrinciple, String engineProvider, String teamName, String driverOne,
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.teamPrinciple == null) ? 0 : this.teamPrinciple.hashCode());
		result = prime * result + ((this.engineProvider == null) ? 0 : this.engineProvider.hashCode());
		result = prime * result + ((this.teamName == null) ? 0 : this.teamName.hashCode());
		result = prime * result + ((this.driverOne == null) ? 0 : this.driverOne.hashCode());
		result = prime * result + ((this.driverTwo == null) ? 0 : this.driverTwo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FantasyF1 other = (FantasyF1) obj;
		if (this.teamPrinciple == null) {
			if (other.teamPrinciple != null)
				return false;
		} else if (!this.teamPrinciple.equals(other.teamPrinciple))
			return false;
		if (this.engineProvider == null) {
			if (other.engineProvider != null)
				return false;
		} else if (!this.engineProvider.equals(other.engineProvider))
			return false;
		if (this.teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!this.teamName.equals(other.teamName))
			return false;
		if (this.driverOne == null) {
			if (other.driverOne != null)
				return false;
		} else if (!this.driverOne.equals(other.driverOne))
			return false;
		if (this.driverTwo == null) {
			if (other.driverTwo != null)
				return false;
		} else if (!this.driverTwo.equals(other.driverTwo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FantasyF1Team [id=" + id + ", teamPrinciple=" + teamPrinciple + ", engineProvider=" + engineProvider
				+ ", teamName=" + teamName + ", driverOne=" + driverOne + ", driverTwo=" + driverTwo + "]";
	}

}