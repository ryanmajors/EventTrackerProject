package com.skilldistillery.dgtournament.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dgtournament.entities.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

	// findByKeyword
//	List<Tournament> findByNameLikeOrLocationLike(String name, String location);

	Tournament findById(int tournamentId);
	
	// findByName

	// findByLocation
	
	// findByTier
	
	// findByMonth
	
	// findByYear
	
	// findByMultiDay
	
	// findByPlayersGreaterThanEquals

	// findByEntryFeeLessThanEquals

	List<Tournament> findByPlacementEquals(int firstPlace);
	
	List<Tournament> findByPlacementLessThanEqual(int placement);	
	
	// findByPointsGreaterThanEquals
	
	//

	
	
}
