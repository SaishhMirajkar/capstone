package com.example.SongAddition.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;
    private String title;
    private String releaseDate;
    private String collabed;
    private Long artistId;
    private Double collaborationPct;
    private String genre;
    private String country;
    private Long collaborationArtistId;
    private Double artist2Pct;
	public Long getCollaborationArtistId() {
		return collaborationArtistId;
	}
	public void setCollaborationArtistId(Long collaborationArtistId) {
		this.collaborationArtistId = collaborationArtistId;
	}
	public Double getArtist2Pct() {
		return artist2Pct;
	}
	public void setArtist2Pct(Double artist2Pct) {
		this.artist2Pct = artist2Pct;
	}
	public Long getSongId() {
		return songId;
	}
	public void setSongId(Long songId) {
		this.songId = songId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getCollabed() {
		return collabed;
	}
	public void setCollabed(String collabed) {
		this.collabed = collabed;
	}
	public Long getArtistId() {
		return artistId;
	}
	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}
	public Double getCollaborationPct() {
		return collaborationPct;
	}
	public void setCollaborationPct(Double collaborationPct) {
		this.collaborationPct = collaborationPct;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean isCollabed() {
        return collaborationArtistId != null; 
    }


    
}
