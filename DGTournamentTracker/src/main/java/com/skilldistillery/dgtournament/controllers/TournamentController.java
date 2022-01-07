package com.skilldistillery.dgtournament.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
