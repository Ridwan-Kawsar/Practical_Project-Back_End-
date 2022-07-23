package com.qa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.entity.Pokemon;

@Repository
public interface PokemonRepo extends JpaRepository<Pokemon, Integer> {

	List<Pokemon> findByNameStartingWithIgnoreCase(String name);
}