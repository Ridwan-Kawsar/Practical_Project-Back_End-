package com.qa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.entity.FantasyF1;

@Repository
public interface FantasyF1Repo extends JpaRepository<FantasyF1, Integer> {

	FantasyF1 findByTeamPrincipleStartingWithIgnoreCase(String teamPrinciple);
}