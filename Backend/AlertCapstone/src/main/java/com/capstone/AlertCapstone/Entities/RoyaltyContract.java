package com.capstone.AlertCapstone.Entities;

import com.capstone.AlertCapstone.Entities.Enums.Approach;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RoyaltyContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artists artist;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Managers manager;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Songs song;

    private Double artistPct;

    @Enumerated(EnumType.STRING)
    private Approach approached;

    private Boolean flag;

    // Getters and Setters
    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Artists getArtist() {
        return artist;
    }

    public void setArtist(Artists artist) {
        this.artist = artist;
    }

    public Managers getManager() {
        return manager;
    }

    public void setManager(Managers manager) {
        this.manager = manager;
    }

    public Songs getSong() {
        return song;
    }

    public void setSong(Songs song) {
        this.song = song;
    }

    public Double getArtistPct() {
        return artistPct;
    }

    public void setArtistPct(Double artistPct) {
        this.artistPct = artistPct;
    }

    public Approach getApproached() {
        return approached;
    }

    public void setApproached(Approach approached) {
        this.approached = approached;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "RoyaltyContract [contractId=" + contractId + ", artist=" + artist + ", manager=" + manager + ", song="
                + song + ", artistPct=" + artistPct + ", approached=" + approached + ", flag=" + flag + "]";
    }
}
