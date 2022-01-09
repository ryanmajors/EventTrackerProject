package com.skilldistillery.dgtournament.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dgtournament.entities.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

	Tournament findById(int tournamentId);
	
	
	// several different searches
	// name
	Tournament findByName(String tournamentName);
	// keyword
	// multiple words different 
	// date range
	// sort by players
	// sort by placement
	
	
	
	
}
