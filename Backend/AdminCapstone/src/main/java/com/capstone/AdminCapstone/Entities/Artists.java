package com.capstone.AdminCapstone.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artists")
public class Artists {

    @Id
    @Column(name = "artist_id")
    private Long artistid;

    private String phone;
    private String stageName;
    private String realName;
    private String country;
    private Long manager_id;
    private boolean deleted = false; 

    public Long getManager_id() {
		return manager_id;
	}

	public void setManager_id(Long manager_id) {
		this.manager_id = manager_id;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Long getManagerid() {
		return manager_id;
	}

	public void setManagerid(Long manager_id) {
		this.manager_id = manager_id;
	}

	public Long getArtistid() {
        return artistid;
    }

    public void setArtistid(Long artistid) {
        this.artistid = artistid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
		return "Artist [artistid=" + artistid + ", phoneNo=" + phone + ", stageName=" + stageName + ", realName="
				+ realName + ", country=" + country + "]";
	}


     
}
