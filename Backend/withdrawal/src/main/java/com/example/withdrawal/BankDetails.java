package com.example.withdrawal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankDetails {
	@Id
	private int userId;
	private String accountNumber;
	private String username;
	private String bankName;
	private String bicCode;
	//private String accountType;
	public String getAccountNumber() {
		return accountNumber;
	}
//	public int getArtistId() {
//		return artistId;
//	}
//	public void setArtistId(int artistId) {
//		this.artistId = artistId;
//	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBicCode() {
		return bicCode;
	}
	public void setBicCode(String bicCode) {
		this.bicCode = bicCode;
	}
//	public String getAccountType() {
//		return accountType;
//	}
//	public void setAccountType(String accountType) {
//		this.accountType = accountType;
//	}
	@Override
	public String toString() {
		return "BankDetails [accountNumber=" + accountNumber + ", username=" + username + ", bankName=" + bankName
				+ ", bicCode=" + bicCode + ", accountType= ";
	}
	
	
	

}
