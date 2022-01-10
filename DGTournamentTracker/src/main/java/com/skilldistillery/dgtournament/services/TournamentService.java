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

	int countTournamentsPlayed();
	
	int countTournamentsPlayedByYear(int tournamentYear);
	
	int countWins();
	
	int countPodiumFinishes();

	int countTop5Finishes();

	int countTop10Finishes();
	
	double calculateAveragePlacement();
	
	double calculateWinPercentage();
	
	double calculatePodiumPercentage();
	
	double calculateTop5Percentage();
	
	double calculateTop10Percentage();
	
	List<Tournament> getTournamentsPlayedByYear(int tournamentYear);
	
	List<Tournament> getAllTournamentWins();
	
	List<Tournament> getAllPodiumFinishes();
	
	List<Tournament> getTop5Finishes();
	
	List<Tournament> getTop10Finishes();

}
