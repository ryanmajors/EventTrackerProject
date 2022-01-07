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
		return null;
	}

}
