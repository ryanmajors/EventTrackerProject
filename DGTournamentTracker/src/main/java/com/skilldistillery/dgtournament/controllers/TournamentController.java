package com.skilldistillery.dgtournament.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.dgtournament.entities.Tournament;
import com.skilldistillery.dgtournament.services.TournamentService;

@RestController
@RequestMapping("api")
public class TournamentController {

	@Autowired
	private TournamentService tournamentService;

	@GetMapping("tournaments")
	public List<Tournament> index() {
		return tournamentService.getAllTournaments();
	}

	@GetMapping("tournaments/{tournamentId}")
	public Tournament show(@PathVariable int tournamentId) {
		return tournamentService.getTournamentById(tournamentId);
	}

	@PostMapping("tournaments")
	public Tournament addNewTournament(HttpServletResponse res, @RequestBody Tournament tournament) {
		Tournament newTournament = tournamentService.addTournament(tournament);
		if (newTournament != null) {
			res.setStatus(201);
		}
		return newTournament;
	}

	@PutMapping("tournaments/{tournamentId}")
	public Tournament updateTournament(@RequestBody Tournament tournament, @PathVariable int tournamentId) {
		return tournamentService.updateTournamentById(tournament, tournamentId);
	}

	@PutMapping("tournaments/{tournamentId}/hide")
	public Tournament hideTournament(@PathVariable int tournamentId) {
		return tournamentService.toggleTournamentVisibilityById(tournamentId);
	}

	@DeleteMapping("tournaments/{tournamentId}")
	public void deleteTournament(@PathVariable int tournamentId) {
		tournamentService.deleteTournamentById(tournamentId);
	}

	@GetMapping("tournaments/stats/year/{tournamentYear}")
	public List<Tournament> getTournamentsPlayedByYear(@PathVariable int tournamentYear) {
		return tournamentService.getTournamentsPlayedByYear(tournamentYear);
	}

	@GetMapping("tournaments/stats/wins")
	public List<Tournament> getTournamentWins() {
		return tournamentService.getAllTournamentWins();
	}
	@GetMapping("tournaments/stats/podiumfinishes")
	public List<Tournament> getPodiumFinishes() {
		return tournamentService.getAllPodiumFinishes();
	}

	@GetMapping("tournaments/stats/top5finishes")
	public List<Tournament> getTop5Finishes() {
		return tournamentService.getTop5Finishes();
	}

	@GetMapping("tournaments/stats/top10finishes")
	public List<Tournament> getTop10Finishes() {
		return tournamentService.getTop10Finishes();
	}
	
	@GetMapping("tournaments/stats/averageplacement")
	public double getAveragePlacement() {
		return tournamentService.calculateAveragePlacement();
	}
	
	@GetMapping("tournaments/stats/podiumfinishes/count")
	public double countPodiumFinishes() {
		return tournamentService.countPodiumFinishes();
	}
	
	@GetMapping("tournaments/stats/wins/percentage")
	public double getWinPercentage() {
		return tournamentService.calculateWinPercentage();
	}
	
	@GetMapping("tournaments/stats/podiumfinishes/percentage")
	public double getPodiumPercentage() {
		return tournamentService.calculatePodiumPercentage();
	}
	
	@GetMapping("tournaments/stats/top5finishes/percentage")
	public double getTop5Percentage() {
		return tournamentService.calculateTop5Percentage();
	}
	
	@GetMapping("tournaments/stats/top10finishes/percentage")
	public double getTop10Percentage() {
		return tournamentService.calculateTop10Percentage();
	}
	
}
