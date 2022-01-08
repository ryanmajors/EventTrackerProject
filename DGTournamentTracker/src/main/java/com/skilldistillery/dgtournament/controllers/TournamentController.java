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
		if(newTournament != null) {
			res.setStatus(201);
		}
		return newTournament;
	}
	
	@PutMapping("tournaments/{tournamentId}")
	public Tournament updateTournament(@RequestBody Tournament tournament, @PathVariable int tournamentId) {
		return tournamentService.updateTournamentById(tournament, tournamentId);
	}
	
	@PutMapping("tournaments/{tournamentId}/hide")
	public Tournament hideTournament(@RequestBody Tournament tournament, @PathVariable int tournamentId) {
		return tournamentService.hideTournamentById(tournament, tournamentId);
	}
	
	@DeleteMapping("tournaments/{tournamentId}")
	public void deleteTournament(@PathVariable int tournamentId) {
		tournamentService.deleteTournamentById(tournamentId);
	}
}
