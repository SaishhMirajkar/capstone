package com.capstone.ArtistCapstone.Entities;

import com.capstone.ArtistCapstone.Modules.ManagerEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ArtistEntity {
	@Id
	private int artistId;
	private long phoneNumber;
	private String stageName;
	private String realName;

	@ManyToOne
	@JoinColumn(name = "managerId") // Foreign key column
	private ManagerEntity manager;

	// Getters and setters
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStageName() {
		return stageName;
	}
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public ManagerEntity getManager() {
		return manager;
	}
	public void setManager(ManagerEntity manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "ArtistEntity [artistId=" + artistId + ", phoneNumber=" + phoneNumber + ", stageName=" + stageName
				+ ", realName=" + realName + ", manager=" + manager + "]";
	}
}
