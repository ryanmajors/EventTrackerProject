package com.skilldistillery.dgtournament.services;

import java.text.DecimalFormat;
import java.util.ArrayList;
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
		;
	}

	@Override
	public int countTournamentsPlayed() {
		return getAllTournaments().size();
	}

	@Override
	public int countTournamentsPlayedByYear(int tournamentYear) {
		return getTournamentsPlayedByYear(tournamentYear).size();
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
	public double calculateAveragePlacement() {
		List<Tournament> allTournaments = tournamentRepo.findAll();
		int total = 0;
		for (Tournament tournament : allTournaments) {
			int tournamentPlacement = tournament.getPlacement();
			total += tournamentPlacement;
		}
		return total/countTournamentsPlayed();
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

	@Override
	public List<Tournament> getTournamentsPlayedByYear(int tournamentYear) {
		List<Tournament> tournaments = tournamentRepo.findAll();
		List<Tournament> tournamentsByYear = new ArrayList<>();
		for (Tournament tournament : tournaments) {
			if (tournament.getYear() == tournamentYear) {
				tournamentsByYear.add(tournament);
			}
		}
		return tournamentsByYear;
	}

}
