package com.skilldistillery.dgtournament.services;

import java.util.List;

import com.skilldistillery.dgtournament.entities.Tournament;

public interface TournamentService {
	
	List<Tournament> getAllTournaments();
	Tournament getTournamentById(int tournamentId);

}
