package com.qa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.entity.Pokedex;
import com.qa.repo.PokedexRepo;

@Service
@Primary
public class PokedexServiceDB implements PokedexService {

	@Autowired
	private PokedexRepo repo;

	@Override
	public Pokedex getById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public List<Pokedex> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Pokedex create(Pokedex pokemon) {
		return this.repo.save(pokemon);
	}

	@Override
	public Pokedex update(int id, String name, String type, String species, Float height,
			Float weight) {
		Pokedex toUpdate = this.getById(id);
		if (name != null)
			toUpdate.setName(name);
		if (type != null)
			toUpdate.setType(type);
		if (species != null)
			toUpdate.setSpecies(species);
		if (height != null)
			toUpdate.setHeight(height);
		if (weight != null)
			toUpdate.setWeight(weight);
		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public Pokedex findByName(String name) {
		return this.repo.findByNameStartingWithIgnoreCase(name);
	}

}