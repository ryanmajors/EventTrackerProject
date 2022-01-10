package com.skilldistillery.dgtournament.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

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
		assertEquals("Winter Fling Presented by Mile High Disc Golf Club", tournament.getName());
	}

	@Test
	void test_find_by_name() {
		Tournament tournament = tournamentRepo.findByName("Winter Fling Presented by Mile High Disc Golf Club");
		assertNotNull(tournament);
		assertEquals(24, tournament.getPlacement());
	}

	@Test
	void test_find_by_name_like_or_location_like() {
		List<Tournament> tournaments = tournamentRepo.findByNameLikeOrLocationLike("Arvada", "Arvada");
		assertNotNull(tournaments);
		assertEquals(1, tournaments.size());
	}

	@Test
	void test_find_by_location() {
		List<Tournament> tournaments = tournamentRepo.findByLocation("Brighton");
		assertNotNull(tournaments);
		assertEquals(6, tournaments.size());
	}

	@Test
	void test_find_by_tier() {
		List<Tournament> tournaments = tournamentRepo.findByTier("A");
		assertNotNull(tournaments);
		assertEquals(7, tournaments.size());
	}

	@Test
	void test_find_by_month() {
		List<Tournament> tournaments = tournamentRepo.findByMonth(5);
		assertNotNull(tournaments);
		assertEquals(6, tournaments.size());
	}

	@Test
	void test_find_by_year() {
		List<Tournament> tournaments = tournamentRepo.findByYear(2021);
		assertNotNull(tournaments);
		assertEquals(15, tournaments.size());
	}

	@Test
	void test_find_by_multiday() {
		List<Tournament> tournaments = tournamentRepo.findByMultiDay(true);
		assertNotNull(tournaments);
		assertEquals(12, tournaments.size());
	}

	@Test
	void test_find_by_players_greater_than_equal() {
		List<Tournament> tournaments = tournamentRepo.findByPlayersGreaterThanEqual(20);
		assertNotNull(tournaments);
		assertEquals(28, tournaments.size());
	}

	@Test
	void test_find_by_entryfee_less_than_equal() {
		List<Tournament> tournaments = tournamentRepo.findByEntryFeeLessThanEqual(60);
		assertNotNull(tournaments);
		assertEquals(18, tournaments.size());
	}

	@Test
	void test_find_by_placement_equals() {
		List<Tournament> tournaments = tournamentRepo.findByPlacementEquals(1);
		assertNotNull(tournaments);
		assertEquals(3, tournaments.size());
	}

	@Test
	void test_find_by_placement_less_than_equals() {
		List<Tournament> tournaments = tournamentRepo.findByPlacementLessThanEqual(10);
		assertNotNull(tournaments);
		assertEquals(21, tournaments.size());
	}

	@Test
	void test_find_by_points_grater_than_equal() {
		List<Tournament> tournaments = tournamentRepo.findByPointsGreaterThanEqual(200);
		assertNotNull(tournaments);
		assertEquals(5, tournaments.size());
	}

}
