package com.skilldistillery.dgtournament.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dgtournament.entities.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
	
	// findById
	Tournament findById(int tournamentId);

	// findByName
	Tournament findByName(String name);
	
	// findByKeyword
	List<Tournament> findByNameLikeOrLocationLike(String name, String location);

	// findByLocation
	List<Tournament> findByLocation(String location);
	
	// findByTier
	List<Tournament> findByTier(String tier);
	
	// findByMonth
	List<Tournament> findByMonth(int month);
	
	// findByYear
	List<Tournament> findByYear(int year);
	
	// findByMultiDay
	List<Tournament> findByMultiDay(boolean multiDay);
	
	// findByPlayersGreaterThanEquals
	List<Tournament> findByPlayersGreaterThanEqual(int players);

	// findByEntryFeeLessThanEquals
	List<Tournament> findByEntryFeeLessThanEqual(double entryFee);

	// findByPlacementEquals
	List<Tournament> findByPlacementEquals(int firstPlace);
	
	// findByPlacementLessThanEqual
	List<Tournament> findByPlacementLessThanEqual(int placement);	
	
	// findByPointsGreaterThanEquals
	List<Tournament> findByPointsGreaterThanEqual(int points);
	
}
