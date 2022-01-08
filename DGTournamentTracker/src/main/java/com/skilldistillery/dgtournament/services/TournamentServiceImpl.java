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
	public Tournament addTournament(Tournament tournament) {
		return tournamentRepo.save(tournament);
	}

	@Override
	public Tournament updateTournamentById(Tournament tournament, int tournamentId) {
		tournament.setId(tournamentId);
		if(tournamentRepo.existsById(tournamentId)) {
			return tournamentRepo.save(tournament);
		}
		return null;
	}
	
	@Override
	public Tournament hideTournamentById(Tournament tournament, int tournamentId) {
		tournament.setId(tournamentId);
		if(tournamentRepo.existsById(tournamentId)) {
			tournament.setHidden(true);
			return tournamentRepo.save(tournament);
		}
		return null;
	}

	@Override
	public void deleteTournamentById(int tournamentId) {
		tournamentRepo.deleteById(tournamentId);;
	}


}
