package com.example.withdrawal.modal;

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
	public String getAccountNumber() {
		return accountNumber;
	}
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
	@Override
	public String toString() {
		return "BankDetails [accountNumber=" + accountNumber + ", username=" + username + ", bankName=" + bankName
				+ ", bicCode=" + bicCode + ", accountType= ";
	}
	
	
	

}
