package com.skilldistillery.dgtournament.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TournamentTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Tournament tournament;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPATournaments");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		tournament = em.find(Tournament.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		tournament = null;
	}

	@Test
	void test_tournament_entity_mapping() {
		assertNotNull(tournament);
		assertEquals("Winter Fling Presented by Mile High Disc Golf Club", tournament.getName());
	}

}
