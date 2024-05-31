package com.example.withdrawal;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MonthlySettlement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int userId ;
	private double dailyRoyalty;
	private LocalDate date;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public double getDailyRoyalty() {
		return dailyRoyalty;
	}
	public void setDailyRoyalty(double dailyRoyalty) {
		this.dailyRoyalty = dailyRoyalty;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	

}
