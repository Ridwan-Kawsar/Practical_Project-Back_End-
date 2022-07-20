package com.qa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.entity.Pokedex;

@Repository
public interface PokedexRepo extends JpaRepository<Pokedex, Integer> {

	Pokedex findByNameStartingWithIgnoreCase(String name);
}