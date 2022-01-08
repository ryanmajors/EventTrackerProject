package com.skilldistillery.dgtournament.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tournament {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String tier;
	
	private String location;
	
	@Column(name="tournament_date")
	private Date tournamentDate;
	
	@Column(name="multi_day")
	private boolean multiDay;
	
	private int days;
	
	private int players;
	
	@Column(name="entry_fee")
	private double entryFee;
	
	private int placement;
	
	private int points;
	
	private boolean hidden;

	public Tournament() {
		super();
	}

	public Tournament(int id, String name, String tier, String location, Date tournamentDate, boolean multiDay, boolean hidden) {
		super();
		this.id = id;
		this.name = name;
		this.tier = tier;
		this.location = location;
		this.tournamentDate = tournamentDate;
		this.multiDay = multiDay;
		this.hidden = hidden;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getTournamentDate() {
		return tournamentDate;
	}

	public void setTournamentDate(Date tournamentDate) {
		this.tournamentDate = tournamentDate;
	}

	public boolean isMultiDay() {
		return multiDay;
	}

	public void setMultiDay(boolean multiDay) {
		this.multiDay = multiDay;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getPlayers() {
		return players;
	}

	public void setPlayers(int players) {
		this.players = players;
	}

	public double getEntryFee() {
		return entryFee;
	}

	public void setEntryFee(double entryFee) {
		this.entryFee = entryFee;
	}

	public int getPlacement() {
		return placement;
	}

	public void setPlacement(int placement) {
		this.placement = placement;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	@Override
	public String toString() {
		return "Tournament [id=" + id + ", name=" + name + ", tier=" + tier + ", location=" + location
				+ ", tournamentDate=" + tournamentDate + ", multiDay=" + multiDay + ", days=" + days + ", players="
				+ players + ", entryFee=" + entryFee + ", placement=" + placement + ", points=" + points + "]";
	}

	
	
}
