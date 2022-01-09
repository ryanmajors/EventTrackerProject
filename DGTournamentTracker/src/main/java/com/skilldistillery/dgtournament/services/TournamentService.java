package com.skilldistillery.dgtournament.services;

import java.util.List;

import com.skilldistillery.dgtournament.entities.Tournament;

public interface TournamentService {
	
	List<Tournament> getAllTournaments();
	
	Tournament getTournamentById(int tournamentId);
	
	Tournament addTournament(Tournament tournament);
	
	Tournament updateTournamentById(Tournament tournament, int tournamentId);
	
	Tournament toggleTournamentVisibilityById(int tournamentId);
	
	void deleteTournamentById(int tournamentId);

	// tournaments played
	
	// tournaments played by year
	
	// wins
	
	// win %

	// average placement
	
	// podium finishes 
	
	// top 5 
	
	// top 10
	
	// 
	
	

}
