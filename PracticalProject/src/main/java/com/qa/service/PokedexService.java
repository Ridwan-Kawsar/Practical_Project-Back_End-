package com.qa.service;

import java.util.List;

import com.qa.entity.Pokedex;

public interface PokedexService {

	Pokedex getById(int id);
	
	List<Pokedex> getAll();

	Pokedex findByName(String name);

	Pokedex create(Pokedex pokemon);

	Pokedex update(int id, String name, String type, String species, Float height, Float weight);

	void delete(int id);
		
}