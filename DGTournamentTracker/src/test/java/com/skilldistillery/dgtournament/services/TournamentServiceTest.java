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
		assertEquals(41, allTournaments.size());
	}

	@Test
	void test_get_tournament_by_id() {
		Tournament tournament = tournamentServiceImpl.getTournamentById(1);
		assertNotNull(tournament);
		assertEquals("Winter Fling Presented by Mile High Disc Golf Club", tournament.getName());
	}

	@Test
	void test_get_tournament_by_name() {
		Tournament tournament = tournamentServiceImpl
				.getTournamentsByName("Winter Fling Presented by Mile High Disc Golf Club");
		assertNotNull(tournament);
		assertEquals(1, tournament.getId());
	}

//	@Test
//	void test_add_tournament() {
//		Tournament tournamentTestObject = tournamentServiceImpl.getTournamentById(1);
//		tournamentTestObject = tournamentServiceImpl.addTournament(tournamentTestObject);
//		assertNotNull(tournamentTestObject);
//		assertEquals("Winter Fling Presented by Mile High Disc Golf Club", tournamentTestObject.getName());
//	}

//	@Test
//	void test_update_tournament_by_id() {
//		Tournament tournamentTestObject = tournamentServiceImpl.getTournamentById(1);
//		tournamentTestObject = tournamentServiceImpl.updateTournamentById(tournamentTestObject, 2);
//		assertNotNull(tournamentTestObject);
//		assertEquals("Winter Fling Presented by Mile High Disc Golf Club", tournamentTestObject.getName());
//	}

//	@Test
//	void test_hide_tournament_by_id() {
//		Tournament tournamentTestObject = tournamentServiceImpl.getTournamentById(1);
//		boolean testObjectHidden = tournamentTestObject.isHidden();
//		tournamentTestObject = tournamentServiceImpl.toggleTournamentVisibilityById(1);
//		assertNotNull(tournamentTestObject);
//		assertTrue(tournamentTestObject.isHidden() == !testObjectHidden);
//	}

//	@Test
//	void test_delete_tournament_by_id() {
//		tournamentServiceImpl.deleteTournamentById(3);
//		Tournament tournamentTestObject = tournamentServiceImpl.getTournamentById(3);
//		assertNull(tournamentTestObject);
//	}

	@Test
	void test_count_tournaemnts_played() {
		int count = tournamentServiceImpl.countTournamentsPlayed();
		assertEquals(41, count);
	}

	@Test
	void test_count_tournaemnts_played_by_year() {
		int count = tournamentServiceImpl.countTournamentsPlayedByYear(2021);
		assertEquals(15, count);
	}

	@Test
	void test_count_wins() {
		int count = tournamentServiceImpl.countWins();
		assertEquals(3, count);
	}

	@Test
	void test_count_podium_finishes() {
		int count = tournamentServiceImpl.countPodiumFinishes();
		assertEquals(10, count);
	}

	@Test
	void test_count_top_5_finishes() {
		int count = tournamentServiceImpl.countTop5Finishes();
		assertEquals(13, count);
	}

	@Test
	void test_count_top_10_finishes() {
		int count = tournamentServiceImpl.countTop10Finishes();
		assertEquals(21, count);
	}

	@Test
	void test_count_total_points_for_all_tournaments() {
		double count = tournamentServiceImpl.countTotalPointsForAllTournaments();
		assertEquals(6695, count);
	}

	@Test
	void test_count_total_points_per_year() {
		double count = tournamentServiceImpl.countTotalPointsPerYear(2021);
		assertEquals(2687, count);
	}

	@Test
	void test_calculate_average_points_per_tournament() {
		double average = tournamentServiceImpl.calculateAveragePointsPerTournament();
		assertEquals(163.29268292682926, average);
	}

	@Test
	void test_calculate_average_points_per_year() {
		double average = tournamentServiceImpl.calculateAveragePointsPerYear(2021);
		assertEquals(671.75, average);
	}

	@Test
	void test_calculate_average_placement() {
		double average = tournamentServiceImpl.calculateAveragePlacement();
		assertEquals(17, average);
	}

	@Test
	void test_calculate_win_percentage() {
		double percentage = tournamentServiceImpl.calculateWinPercentage();
		assertEquals(7, percentage);
	}

	@Test
	void test_calculate_podium_percentage() {
		double percentage = tournamentServiceImpl.calculatePodiumPercentage();
		assertEquals(24, percentage);
	}

	@Test
	void test_calculate_top_5_percentage() {
		double percentage = tournamentServiceImpl.calculateTop5Percentage();
		assertEquals(31, percentage);
	}

	@Test
	void test_calculate_top_10_percentage() {
		double percentage = tournamentServiceImpl.calculateTop10Percentage();
		assertEquals(51, percentage);
	}

	@Test
	void test_get_all_tournaments_by_name_or_by_location() {
		List<Tournament> tournaments = tournamentServiceImpl.getAllTournamentsByNameOrLocation("Arvada");
		assertNotNull(tournaments);
		assertTrue(tournaments.size() == 1);
	}

	@Test
	void test_get_all_tournaments_by_location() {
		List<Tournament> tournaments = tournamentServiceImpl.getAllTournamentsByLocation("Brighton");
		assertNotNull(tournaments);
		assertTrue(tournaments.size() == 6);
	}

	@Test
	void test_get_all_tournaments_by_tier() {
		List<Tournament> tournaments = tournamentServiceImpl.getAllTournamentsByTier("A");
		assertNotNull(tournaments);
		assertTrue(tournaments.size() == 7);
	}

	@Test
	void test_get_all_tournaments_by_month() {
		List<Tournament> tournaments = tournamentServiceImpl.getAllTournamentsByMonth(5);
		assertNotNull(tournaments);
		assertTrue(tournaments.size() == 6);
	}

	@Test
	void test_get_all_tournaments_by_year() {
		List<Tournament> tournaments = tournamentServiceImpl.getAllTournamentsByYear(2021);
		assertNotNull(tournaments);
		assertTrue(tournaments.size() == 15);
	}

	@Test
	void test_get_all_tournaments_by_multi_day() {
		List<Tournament> tournaments = tournamentServiceImpl.getAllTournamentsByMultiDay(true);
		assertNotNull(tournaments);
		assertTrue(tournaments.size() == 12);
	}

	@Test
	void test_get_all_tournaments_by_players_greater_than_equal() {
		List<Tournament> tournaments = tournamentServiceImpl.getAllTournamentsByPlayersGreaterThanEqual(20);
		assertNotNull(tournaments);
		assertTrue(tournaments.size() == 28);
	}

	@Test
	void test_get_all_tournaments_by_entry_fee_less_than_equal() {
		List<Tournament> tournaments = tournamentServiceImpl.getAllTournamentsByEntryFeeLessThanEqual(60);
		assertNotNull(tournaments);
		assertTrue(tournaments.size() == 18);
	}

	@Test
	void test_get_all_tournaments_by_points_greater_than_equal() {
		List<Tournament> tournaments = tournamentServiceImpl.getAllTournamentsByPointsGreaterThanEqual(200);
		assertNotNull(tournaments);
		assertTrue(tournaments.size() == 5);
	}

	@Test
	void test_get_all_tournament_wins() {
		List<Tournament> tournaments = tournamentServiceImpl.getAllTournamentWins();
		assertNotNull(tournaments);
		assertEquals(3, tournaments.size());
	}

	@Test
	void test_get_all_podium_finishes() {
		List<Tournament> tournaments = tournamentServiceImpl.getAllPodiumFinishes();
		assertNotNull(tournaments);
		assertEquals(10, tournaments.size());
	}

	@Test
	void test_get_all_top_5_finishes() {
		List<Tournament> tournaments = tournamentServiceImpl.getAllTop5Finishes();
		assertNotNull(tournaments);
		assertEquals(13, tournaments.size());
	}

	@Test
	void test_get_all_top_10_finishes() {
		List<Tournament> tournaments = tournamentServiceImpl.getAllTop10Finishes();
		assertNotNull(tournaments);
		assertEquals(21, tournaments.size());
	}
}
