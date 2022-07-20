package com.qa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Table
public class Pokedex {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Integer id;

	private String name;
	private String type;
	private String species;
	private Float height;
	private Float weight;

	public Pokedex() {
		super();
		// REQUIRED
	}

	public Pokedex(String name, String type, String species, Float height, Float weight) {
		super();
		this.name = name;
		this.type = type;
		this.species = species;
		this.height = height;
		this.weight = weight;
	}

	public Pokedex(Integer id, String name, String type, String species, Float height,
			Float weight) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.species = species;
		this.height = height;
		this.weight = weight;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Pokedex [id=" + id + ", name=" + name + ", type=" + type + ", species=" + species + ", height=" + height
				+ ", weight=" + weight + "]";
	}
	
}