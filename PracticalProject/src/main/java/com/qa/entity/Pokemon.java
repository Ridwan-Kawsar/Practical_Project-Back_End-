package com.qa.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Table
public class Pokemon {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Integer id;

	private String name;
	private String type;
	private String species;
	private Integer health;
	private Integer attack;
	private Integer defense;

	public Pokemon() {
		super();
		// REQUIRED
	}

	public Pokemon(String name, String type, String species, Integer health, Integer attack, Integer defense) {
		super();
		this.name = name;
		this.type = type;
		this.species = species;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
	}

	public Pokemon(Integer id, String name, String type, String species, Integer health, Integer attack,
			Integer defense) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.species = species;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
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

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	public Integer getDefense() {
		return defense;
	}

	public void setDefense(Integer defense) {
		this.defense = defense;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attack, defense, health, id, name, species, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return Objects.equals(attack, other.attack) && Objects.equals(defense, other.defense)
				&& Objects.equals(health, other.health) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(species, other.species)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Pokedex [id=" + id + ", name=" + name + ", type=" + type + ", species=" + species + ", health=" + health
				+ ", attack=" + attack + ", defense=" + defense + "]";
	}

}