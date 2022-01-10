package com.skilldistillery.dgtournament.services;

import java.util.List;

import com.skilldistillery.dgtournament.entities.Tournament;

public interface TournamentService {

	List<Tournament> getAllTournaments();

	Tournament getTournamentById(int tournamentId);

	Tournament getTournamentsByName(String name);

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

	double countTotalPointsForAllTournaments();

	double countTotalPointsPerYear(int year);

	double calculateAveragePointsPerTournament();

	double calculateAveragePointsPerYear(int year);

	double calculateAveragePlacement();

	double calculateWinPercentage();

	double calculatePodiumPercentage();

	double calculateTop5Percentage();

	double calculateTop10Percentage();

	List<Tournament> getAllTournamentsByNameOrLocation(String keyword);

	List<Tournament> getAllTournamentsByLocation(String location);

	List<Tournament> getAllTournamentsByTier(String tier);

	List<Tournament> getAllTournamentsByMonth(int month);

	List<Tournament> getAllTournamentsByYear(int tournamentYear);

	List<Tournament> getAllTournamentsByMultiDay(boolean multiDay);

	List<Tournament> getAllTournamentsByPlayersGreaterThanEqual(int players);

	List<Tournament> getAllTournamentsByEntryFeeLessThanEqual(double entryFee);

	List<Tournament> getAllTournamentsByPointsGreaterThanEqual(int points);

	List<Tournament> getAllTournamentWins();

	List<Tournament> getAllPodiumFinishes();

	List<Tournament> getAllTop5Finishes();

	List<Tournament> getAllTop10Finishes();

}
