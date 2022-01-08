package com.skilldistillery.dgtournament.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dgtournament.entities.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

	Tournament findById(int tournamentId);
}
