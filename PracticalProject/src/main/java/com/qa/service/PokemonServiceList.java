//package com.qa.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.qa.entity.Pokemon;
//
//@Service
//public class PokemonServiceList implements PokemonService {
//
//	private List<Pokemon> pokemon = new ArrayList<>();
//
//	@Override
//	public Pokemon getById(int id) {
//		return this.pokemon.get(id);
//	}
//
//	@Override
//	public List<Pokemon> getAll() {
//		return this.pokemon;
//	}
//
//	@Override
//	public Pokemon create(Pokemon pokemon) {
//		this.pokemon.add(pokemon);
//		return this.pokemon.get(this.pokemon.size() - 1);
//	}
//
//	@Override
//	public Pokemon update(int id, String name, String type, String species, Integer health,
//			Integer attack, Integer defense ) {
//		Pokemon toUpdate = this.pokemon.get(id);
//		if (name != null)
//			toUpdate.setName(name);
//		if (type != null)
//			toUpdate.setType(type);
//		if (species != null)
//			toUpdate.setSpecies(species);
//		if (health != null)
//			toUpdate.setHealth(health);
//		if (attack != null)
//			toUpdate.setAttack(attack);
//		return toUpdate;
//	}
//
//	@Override
//	public void delete(int id) {
//		this.pokemon.remove(id);
//	}
//
//	@Override
//	public Pokemon findByName(String name) {
//		return null;
//	}
//}