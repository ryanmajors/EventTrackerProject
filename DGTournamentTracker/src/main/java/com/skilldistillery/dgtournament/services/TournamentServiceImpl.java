package com.skilldistillery.dgtournament.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.dgtournament.entities.Tournament;
import com.skilldistillery.dgtournament.repositories.TournamentRepository;

@Service
public class TournamentServiceImpl implements TournamentService {

	@Autowired
	private TournamentRepository tournamentRepo;

	@Override
	public List<Tournament> getAllTournaments() {
		return tournamentRepo.findAll();
	}

	@Override
	public Tournament getTournamentById(int tournamentId) {
		return tournamentRepo.findById(tournamentId);
	}

	@Override
	public Tournament getTournamentsByName(String name) {
		return tournamentRepo.findByName(name);
	}

	@Override
	public Tournament addTournament(Tournament tournament) {
		return tournamentRepo.save(tournament);
	}

	@Override
	public Tournament updateTournamentById(Tournament tournament, int tournamentId) {
		tournament.setId(tournamentId);
		if (tournamentRepo.existsById(tournamentId)) {
			return tournamentRepo.save(tournament);
		}
		return null;
	}

	@Override
	public Tournament toggleTournamentVisibilityById(int tournamentId) {
		Tournament tournament = tournamentRepo.findById(tournamentId);
		if (tournament.isHidden() == false) {
			tournament.setHidden(true);
			return tournamentRepo.saveAndFlush(tournament);
		} else {
			tournament.setHidden(false);
			return tournamentRepo.saveAndFlush(tournament);
		}
	}

	@Override
	public void deleteTournamentById(int tournamentId) {
		tournamentRepo.deleteById(tournamentId);
	}

	@Override
	public int countTournamentsPlayed() {
		return getAllTournaments().size();
	}

	@Override
	public int countTournamentsPlayedByYear(int tournamentYear) {
		return getAllTournamentsByYear(tournamentYear).size();
	}

	@Override
	public int countWins() {
		return getAllTournamentWins().size();
	}

	@Override
	public int countPodiumFinishes() {
		return getAllPodiumFinishes().size();
	}

	@Override
	public int countTop5Finishes() {
		return getTop5Finishes().size();
	}

	@Override
	public int countTop10Finishes() {
		return getTop10Finishes().size();
	}

	@Override
	public double countTotalPointsForAllTournaments() {
		List<Tournament> allTournament = tournamentRepo.findAll();
		double totalPoints = 0;
		for (Tournament tournament : allTournament) {
			totalPoints += tournament.getPoints();
		}
		return totalPoints;
	}

	@Override
	public double countTotalPointsPerYear(int year) {
		List<Tournament> tournamentsByYear = tournamentRepo.findByYear(year);
		double totalPointsByYear = 0;
		for (Tournament tournament : tournamentsByYear) {
			totalPointsByYear += tournament.getPoints();
		}
		return totalPointsByYear;
	}

	@Override
	public double calculateAveragePointsPerTournament() {
		return countTotalPointsForAllTournaments() / countTournamentsPlayed();
	}

	@Override
	public double calculateAveragePointsPerYear(int year) {
		return countTotalPointsPerYear(year) / countTournamentsPlayedByYear(year);
	}

	@Override
	public double calculateAveragePlacement() {
		List<Tournament> allTournaments = tournamentRepo.findAll();
		int total = 0;
		for (Tournament tournament : allTournaments) {
			total += tournament.getPlacement();
		}
		return total / countTournamentsPlayed();
	}

	@Override
	public double calculateWinPercentage() {
		return (countWins() * 100) / countTournamentsPlayed();
	}

	@Override
	public double calculatePodiumPercentage() {
		return (countPodiumFinishes() * 100) / countTournamentsPlayed();
	}

	@Override
	public double calculateTop5Percentage() {
		return countTop5Finishes() * 100 / countTournamentsPlayed();
	}

	@Override
	public double calculateTop10Percentage() {
		return (countTop10Finishes() * 100) / countTournamentsPlayed();
	}

	@Override
	public List<Tournament> getAllTournamentsByNameOrLocation(String keyword) {
		String keywordSearch = "%" + keyword + "%";
		return tournamentRepo.findByNameLikeOrLocationLike(keywordSearch, keywordSearch);
	}

	@Override
	public List<Tournament> getAllTournamentsByLocation(String location) {
		return tournamentRepo.findByLocation(location);
	}

	@Override
	public List<Tournament> getAllTournamentsByTier(String tier) {
		return tournamentRepo.findByTier(tier);
	}

	@Override
	public List<Tournament> getAllTournamentsByMonth(int month) {
		return tournamentRepo.findByMonth(month);
	}

	@Override
	public List<Tournament> getAllTournamentsByYear(int tournamentYear) {
		return tournamentRepo.findByYear(tournamentYear);
	}

	@Override
	public List<Tournament> getAllTournamentsByMultiDay(boolean multiDay) {
		return tournamentRepo.findByMultiDay(multiDay);
	}

	@Override
	public List<Tournament> getAllTournamentsByPlayersGreaterThanEqual(int players) {
		return tournamentRepo.findByPlayersGreaterThanEqual(players);
	}

	@Override
	public List<Tournament> getAllTournamentsByEntryFeeLessThanEqual(double entryFee) {
		return tournamentRepo.findByEntryFeeLessThanEqual(entryFee);
	}
	
	@Override
	public List<Tournament> getAllTournamentsByPointsGreaterThanEqual(int points) {
		return tournamentRepo.findByPointsGreaterThanEqual(points);
	}

	@Override
	public List<Tournament> getAllTournamentWins() {
		return tournamentRepo.findByPlacementEquals(1);
	}

	@Override
	public List<Tournament> getAllPodiumFinishes() {
		return tournamentRepo.findByPlacementLessThanEqual(3);
	}

	@Override
	public List<Tournament> getTop5Finishes() {
		return tournamentRepo.findByPlacementLessThanEqual(5);
	}

	@Override
	public List<Tournament> getTop10Finishes() {
		return tournamentRepo.findByPlacementLessThanEqual(10);
	}

}
