package com.skilldistillery.dgtournament.entities;

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

	private int month;

	private int year;

	@Column(name = "multi_day")
	private boolean multiDay;

	private int days;

	private int players;

	@Column(name = "entry_fee")
	private double entryFee;

	private int placement;

	private int points;

	private boolean hidden;

	public Tournament() {
		super();
	}

	public Tournament(String name, String tier, String location, int month, boolean multiDay, boolean hidden) {
		super();
		this.name = name;
		this.tier = tier;
		this.location = location;
		this.month = month;
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

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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
		return "Tournament [id=" + id + ", name=" + name + ", tier=" + tier + ", location=" + location + ", month="
				+ month + ", multiDay=" + multiDay + ", days=" + days + ", players=" + players + ", entryFee="
				+ entryFee + ", placement=" + placement + ", points=" + points + "]";
	}

}
