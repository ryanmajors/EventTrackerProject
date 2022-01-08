package com.skilldistillery.dgtournament.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.dgtournament.entities.Tournament;

@SpringBootTest
class TournamentServiceTest {
	
	@Autowired
	private TournamentServiceImpl tournamentServiceImpl;
	

	@Test
	void test_get_all_tournaments() {
		List<Tournament> allTournaments = tournamentServiceImpl.getAllTournaments(); 
		assertNotNull(allTournaments);
		assertEquals(8, allTournaments.size());
	}
	
	@Test
	void test_get_tournament_by_id() {
		Tournament tournament = tournamentServiceImpl.getTournamentById(1);
		assertNotNull(tournament);
		assertEquals("Mile High Classic", tournament.getName());
	}
	
	@Test
	void test_add_tournament() {
		Tournament tournamentTestObject = tournamentServiceImpl.getTournamentById(1);
		tournamentTestObject = tournamentServiceImpl.addTournament(tournamentTestObject);
		assertNotNull(tournamentTestObject);
		assertEquals("Mile High Classic", tournamentTestObject.getName());
	}
	@Test
	void test_update_tournament_by_id() {
		Tournament tournamentTestObject = tournamentServiceImpl.getTournamentById(1);
		tournamentTestObject = tournamentServiceImpl.updateTournamentById(tournamentTestObject, 2);
		assertNotNull(tournamentTestObject);
		assertEquals("Mile High Classic", tournamentTestObject.getName());
		
	}
	@Test
	void test_hide_tournament_by_id() {
		Tournament tournamentTestObject = tournamentServiceImpl.getTournamentById(1);
		boolean testObjectHidden = tournamentTestObject.isHidden();
		tournamentTestObject = tournamentServiceImpl.toggleTournamentVisibilityById(1);
		assertNotNull(tournamentTestObject);
		assertTrue(tournamentTestObject.isHidden() == !testObjectHidden);
	}
	@Test
	void test_delete_tournament_by_id() {
		tournamentServiceImpl.deleteTournamentById(6);
		Tournament tournamentTestObject = tournamentServiceImpl.getTournamentById(6);
		assertNull(tournamentTestObject);
	}

}
