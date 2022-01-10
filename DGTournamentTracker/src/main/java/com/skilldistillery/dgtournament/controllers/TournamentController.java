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

	@GetMapping("tournaments/name/{tournamentName}")
	public Tournament getTournamentByName(@PathVariable String tournamentName) {
		return tournamentService.getTournamentsByName(tournamentName);
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

	@GetMapping("tournaments/search/keyword/{keyword}")
	public List<Tournament> searchTournamentsByKeyword(@PathVariable String keyword) {
		return tournamentService.getAllTournamentsByNameOrLocation(keyword);
	}

	@GetMapping("tournaments/search/location/{location}")
	public List<Tournament> searchTournamentsByLocation(@PathVariable String location) {
		return tournamentService.getAllTournamentsByLocation(location);
	}

	@GetMapping("tournaments/search/teir/{teir}")
	public List<Tournament> searchTournamentsByTier(@PathVariable String tier) {
		return tournamentService.getAllTournamentsByTier(tier);
	}

	@GetMapping("tournaments/search/month/{month}")
	public List<Tournament> searchTournamentsByMonth(@PathVariable int month) {
		return tournamentService.getAllTournamentsByMonth(month);
	}

	@GetMapping("tournaments/search/year/{year}")
	public List<Tournament> searchTournamentsByYear(@PathVariable int year) {
		return tournamentService.getAllTournamentsByYear(year);
	}

	@GetMapping("tournaments/search/multiday{multiDay}")
	public List<Tournament> searchTournamentsByYear(@PathVariable boolean multiDay) {
		return tournamentService.getAllTournamentsByMultiDay(multiDay);
	}

	@GetMapping("tournaments/search/players{players}")
	public List<Tournament> searchTournamentsByPlayersGreaterThanEqual(@PathVariable int players) {
		return tournamentService.getAllTournamentsByPlayersGreaterThanEqual(players);
	}

	@GetMapping("tournaments/search/entryfee{entryFee}")
	public List<Tournament> searchTournamentsByEntryFeeLessThanEqual(@PathVariable int entryFee) {
		return tournamentService.getAllTournamentsByEntryFeeLessThanEqual(entryFee);
	}

	@GetMapping("tournaments/search/points{points}")
	public List<Tournament> searchTournamentsByPointsGreaterThanEqual(@PathVariable int points) {
		return tournamentService.getAllTournamentsByPointsGreaterThanEqual(points);
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

}
