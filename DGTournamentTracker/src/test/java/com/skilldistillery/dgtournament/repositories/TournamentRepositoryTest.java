package com.skilldistillery.dgtournament.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.dgtournament.entities.Tournament;

@SpringBootTest
class TournamentRepositoryTest {
	
	@Autowired
	private TournamentRepository tournamentRepo;

	@Test
	void test_find_by_id() {
		Tournament tournament = tournamentRepo.findById(1);
		assertNotNull(tournament);
		assertEquals("Mile High Classic", tournament.getName());
	}

}
