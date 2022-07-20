//package com.qa.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.qa.entity.Pokedex;
//
//@Service
//public class PokedexServiceList implements PokedexService {
//
//	private List<Pokedex> pokedex = new ArrayList<>();
//
//	@Override
//	public Pokedex getById(int id) {
//		return this.pokedex.get(id);
//	}
//
//	@Override
//	public List<Pokedex> getAll() {
//		return this.pokedex;
//	}
//
//	@Override
//	public Pokedex create(Pokedex pokemon) {
//		this.pokedex.add(pokemon);
//		return this.pokedex.get(this.pokedex.size() - 1);
//	}
//
//	@Override
//	public Pokedex update(int id, String name, String type, String species, Float height,
//			Float weight) {
//		Pokedex toUpdate = this.pokedex.get(id);
//		if (name != null)
//			toUpdate.setName(name);
//		if (type != null)
//			toUpdate.setType(type);
//		if (species != null)
//			toUpdate.setSpecies(species);
//		if (height != null)
//			toUpdate.setHeight(height);
//		if (weight != null)
//			toUpdate.setWeight(weight);
//		return toUpdate;
//	}
//
//	@Override
//	public void delete(int id) {
//		this.pokedex.remove(id);
//	}
//
//	@Override
//	public Pokedex findByName(String name) {
//		return null;
//	}
//}