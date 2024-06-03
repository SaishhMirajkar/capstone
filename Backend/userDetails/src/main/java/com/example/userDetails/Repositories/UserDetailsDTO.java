package com.example.userDetails.Repositories;

import java.util.List;

import com.example.userDetails.model.Artist;
import com.example.userDetails.model.Manager;
import com.example.userDetails.model.User;

public class UserDetailsDTO {
    private User user;
    private Artist artist;
    private Manager manager;
    private String userType;
    private List<Long> artistIds;
    
    
//	public UserDetailsDTO(User user, Artist artist, Manager manager, String userType, List<Long> artistIds) {
//		super();
//		this.user = user;
//		this.artist = artist;
//		this.manager = manager;
//		this.userType = userType;
//		this.artistIds = artistIds;
//	}
	public UserDetailsDTO(User user, Artist artist, Manager manager, String userType) {
		super();
		this.user = user;
		this.artist = artist;
		this.manager = manager;
		this.userType = userType;

	}
	public List<Long> getArtistIds() {
		return artistIds;
	}
	public void setArtistIds(List<Long> artistIds) {
		this.artistIds = artistIds;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}

    // Constructor, getters, and setters
    
}