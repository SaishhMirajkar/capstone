package com.capstone.Manager.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class ManagerEntity {
	@Id
	private int managerId;
	private String company;
	private double managerPct;

	@OneToMany(mappedBy = "managerId") // 'manager' is the field in ArtistEntity that owns the relationship
	private List<ArtistEntity> artists;

	// Getters and setters
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getManagerPct() {
		return managerPct;
	}
	public void setManagerPct(double managerPct) {
		this.managerPct = managerPct;
	}
	public List<ArtistEntity> getArtists() {
		return artists;
	}
	public void setArtists(List<ArtistEntity> artists) {
		this.artists = artists;
	}
}
