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
	public List<Tournament> index(HttpServletResponse res) {
		List<Tournament> tournaments = tournamentService.getAllTournaments();
		if(tournaments.size() <= 0) {
			res.setStatus(404);
		} else {
			res.setStatus(200);
		}
		return tournaments;
	}

	@GetMapping("tournaments/{tournamentId}")
	public Tournament show(@PathVariable int tournamentId, HttpServletResponse res) {
		Tournament tournament =  tournamentService.getTournamentById(tournamentId);
		if(tournament == null) {
			res.setStatus(404);
		} else {
			res.setStatus(200);
		}
		return tournament;
	}

	@GetMapping("tournaments/name/{tournamentName}")
	public Tournament getTournamentByName(@PathVariable String tournamentName, HttpServletResponse res) {
		Tournament tournament = tournamentService.getTournamentsByName(tournamentName);
		if(tournament == null) {
			res.setStatus(404);
		} else {
			res.setStatus(200);
		}
		return tournament;
	}

	@PostMapping("tournaments")
	public Tournament addNewTournament(HttpServletResponse res, @RequestBody Tournament tournament) {
		Tournament newTournament = tournamentService.addTournament(tournament);
		if (newTournament == null) {
			res.setStatus(400);
		} else {
			res.setStatus(201);
		}
		return newTournament;
	}

	@PutMapping("tournaments/{tournamentId}")
	public Tournament updateTournament(@RequestBody Tournament tournament, @PathVariable int tournamentId, HttpServletResponse res) {
		Tournament updatedTournament = tournamentService.updateTournamentById(tournament, tournamentId);
		if(updatedTournament != tournament) {
			res.setStatus(200);
		} else {
			res.setStatus(400);
		}
		return updatedTournament;
	}

	@PutMapping("tournaments/{tournamentId}/hide")
	public Tournament hideTournament(@PathVariable int tournamentId, HttpServletResponse res) {
		Tournament hiddenTournament = tournamentService.toggleTournamentVisibilityById(tournamentId);
		// if(hiddenTournament != tournament) {
		// 	res.setStatus(200);
		// } else {
		// 	res.setStatus(400);
		// }
		return hiddenTournament;
	}

	@DeleteMapping("tournaments/{tournamentId}")
	public void deleteTournament(@PathVariable int tournamentId) {
		tournamentService.deleteTournamentById(tournamentId);
	}

	@GetMapping("tournaments/search/keyword/{keyword}")
	public List<Tournament> searchTournamentsByKeyword(@PathVariable String keyword) {
		return tournamentService.getAllTournamentsByNameOrLocation(keyword);
	}

	@GetMapping("tournaments/filter/location/{location}")
	public List<Tournament> filterTournamentsByLocation(@PathVariable String location) {
		return tournamentService.getAllTournamentsByLocation(location);
	}

	@GetMapping("tournaments/filter/tier/{tier}")
	public List<Tournament> filterTournamentsByTier(@PathVariable String tier) {
		return tournamentService.getAllTournamentsByTier(tier);
	}

	@GetMapping("tournaments/filter/month/{month}")
	public List<Tournament> filterTournamentsByMonth(@PathVariable int month) {
		return tournamentService.getAllTournamentsByMonth(month);
	}

	@GetMapping("tournaments/filter/year/{year}")
	public List<Tournament> filterTournamentsByYear(@PathVariable int year) {
		return tournamentService.getAllTournamentsByYear(year);
	}
	
	@GetMapping("tournaments/filter/multiday/{multiDay}")
	public List<Tournament> filterTournamentsByMultiDay(@PathVariable boolean multiDay) {
		return tournamentService.getAllTournamentsByMultiDay(multiDay);
	}

	@GetMapping("tournaments/filter/players/{players}")
	public List<Tournament> filterTournamentsByPlayersGreaterThanEqual(@PathVariable int players) {
		return tournamentService.getAllTournamentsByPlayersGreaterThanEqual(players);
	}

	@GetMapping("tournaments/filter/entryfee/{entryFee}")
	public List<Tournament> filterTournamentsByEntryFeeLessThanEqual(@PathVariable int entryFee) {
		return tournamentService.getAllTournamentsByEntryFeeLessThanEqual(entryFee);
	}

	@GetMapping("tournaments/filter/points/{points}")
	public List<Tournament> filterTournamentsByPointsGreaterThanEqual(@PathVariable int points) {
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
		return tournamentService.getAllTop5Finishes();
	}

	@GetMapping("tournaments/stats/top10finishes")
	public List<Tournament> getTop10Finishes() {
		return tournamentService.getAllTop10Finishes();
	}

}
