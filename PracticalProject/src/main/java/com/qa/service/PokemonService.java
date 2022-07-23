package com.qa.service;

import java.util.List;

import com.qa.entity.Pokemon;

public interface PokemonService {

	Pokemon getById(int id);
	
	List<Pokemon> getAll();

	List<Pokemon> findByName(String name);

	Pokemon create(Pokemon pokemon);

	Pokemon update(int id, String name, String type, String species, Integer health, Integer attack, Integer defence);

	void delete(int id);
		
}