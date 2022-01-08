package com.skilldistillery.dgtournament.services;

import java.util.List;

import com.skilldistillery.dgtournament.entities.Tournament;

public interface TournamentService {
	
	List<Tournament> getAllTournaments();
	
	Tournament getTournamentById(int tournamentId);
	
	Tournament addTournament(Tournament tournament);
	
	Tournament updateTournamentById(Tournament tournament, int tournamentId);
	
	Tournament hideTournamentById(Tournament tournament, int tournamentId);
	
	void deleteTournamentById(int tournamentId);
	
	

}
