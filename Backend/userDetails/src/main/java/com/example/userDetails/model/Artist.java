package com.example.userDetails.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artistid;
    private String country;
//    //adding newly
//    @ManyToOne
//    @JoinColumn(name = "managerid")
//    @ManyToOne
//    @JoinColumn(name = "managerid")
//    private Manager manager;
    private Long managerid;
    private String phone_no;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;
    // getters and setters

	public Long getArtistid() {
		return artistid;
	}

	public void setArtistid(Long artistid) {
		this.artistid = artistid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getManagerid() {
		return managerid;
	}

	public void setManagerid(Long managerid) {
		this.managerid = managerid;
	}

//	public Manager getManager() {
//		return manager;
//	}
//
//	public void setManager(Manager manager) {
//		this.manager = manager;
//	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}
