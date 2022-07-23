package com.qa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.entity.Pokemon;
import com.qa.repo.PokemonRepo;

@Service
@Primary
public class PokemonServiceDB implements PokemonService {

	@Autowired
	private PokemonRepo repo;

	@Override
	public Pokemon getById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public List<Pokemon> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Pokemon create(Pokemon pokemon) {
		return this.repo.save(pokemon);
	}

	@Override
	public Pokemon update(int id, String name, String type, String species, Integer health,
			Integer attack, Integer defense) {
		Pokemon toUpdate = this.getById(id);
		if (name != null)
			toUpdate.setName(name);
		if (type != null)
			toUpdate.setType(type);
		if (species != null)
			toUpdate.setSpecies(species);
		if (health != null)
			toUpdate.setHealth(health);
		if (attack != null)
			toUpdate.setAttack(attack);
		if (defense != null)
			toUpdate.setDefense(defense);
		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public List<Pokemon> findByName(String name) {
		return this.repo.findByNameStartingWithIgnoreCase(name);
	}

}