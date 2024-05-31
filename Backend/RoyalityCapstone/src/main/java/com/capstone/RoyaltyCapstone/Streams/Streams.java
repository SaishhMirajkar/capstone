package com.capstone.RoyaltyCapstone.Streams;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "streams") // Ensure this matches the actual table name in your MySQL database
public class Streams {
    @Id
    private int streamId;
    private Date date;
    private int songId; 
    private int streams; 
    private Double royalty; 
    public Double getRoyalty() {
		return royalty;
	}
	public void setRoyalty(Double royalty) {
		this.royalty = royalty;
	}
	private boolean flag;
	public int getStreamId() {
		return streamId;
	}
	public void setStreamId(int streamId) {
		this.streamId = streamId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public int getStreams() {
		return streams;
	}
	public void setStreams(int streams) {
		this.streams = streams;
	}
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	} 
    
    
    

    
}
