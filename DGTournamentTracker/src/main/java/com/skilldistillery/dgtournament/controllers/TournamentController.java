package com.skilldistillery.dgtournament.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

}
