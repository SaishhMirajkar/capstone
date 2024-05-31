package com.capstone.DashboardCapstone.Entites;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Managers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Double getManagerPct() {
		return managerPct;
	}

	public void setManagerPct(Double managerPct) {
		this.managerPct = managerPct;
	}

	public List<Artists> getArtists() {
		return artists;
	}

	@Override
	public String toString() {
		return "Managers [managerId=" + managerId + ", company=" + company + ", managerPct=" + managerPct + ", artists="
				+ artists + "]";
	}

	public void setArtists(List<Artists> artists) {
		this.artists = artists;
	}

	private String company;
    private Double managerPct;
    
    @OneToMany(mappedBy = "manager")
    private List<Artists> artists;
}
