package com.RoyaltyManagement.ManagerRequest.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artist")
public class Artist {

    @Id
    private Long artistid;

    private String phoneNo;
    private String stageName;
    private String realName;
    private String country;
    private Long managerid;

//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "artistid")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "managerid")
//    private User manager;

    // Getters and setters
//    public User getManager() {
//        return manager;
//    }
//
//    public void setManager(User manager) {
//        this.manager = manager;
//    }

    public Long getManagerid() {
		return managerid;
	}

	public void setManagerid(Long managerid) {
		this.managerid = managerid;
	}

	public Long getArtistid() {
        return artistid;
    }

    public void setArtistid(Long artistid) {
        this.artistid = artistid;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

	@Override
	public String toString() {
		return "Artist [artistid=" + artistid + ", phoneNo=" + phoneNo + ", stageName=" + stageName + ", realName="
				+ realName + ", country=" + country + "]";
	}

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
     
}
