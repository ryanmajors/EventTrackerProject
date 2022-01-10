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

	@Test
	void test_find_by_name() {
		Tournament tournament = tournamentRepo.findByName("Mile High Classic");
		assertNotNull(tournament);
		assertEquals(1, tournament.getPlacement());
	}

	@Test
	void test_find_by_name_like_or_location_like() {

	}

	@Test
	void test_find_by_location() {

	}

	@Test
	void test_find_by_tier() {

	}

	@Test
	void test_find_by_month() {

	}

	@Test
	void test_find_by_year() {

	}

	@Test
	void test_find_by_multiday() {

	}

	@Test
	void test_find_by_players_greater_than_equal() {

	}

	@Test
	void test_find_by_entryfee_less_than_equal() {

	}

	@Test
	void test_find_by_placement_equals() {

	}

	@Test
	void test_find_by_placement_less_than_equals() {

	}

	@Test
	void test_find_by_points_grater_than_equal() {

	}

}
