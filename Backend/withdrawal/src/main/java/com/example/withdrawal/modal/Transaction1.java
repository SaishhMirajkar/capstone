package com.example.withdrawal.modal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;

@Entity
public class Transaction1 {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    
    private Double amount;
    
    private LocalDate dateCreated;
    
    private String accountNumber;
    private String username;
    private String accountType;
    private String bankName;
    private int userId;
   // private double earning;
    
//    @ManyToOne
//    @JoinColumn(name = "bank_details_id")
//    private BankDetails bankDetails;

//	public int getPaymentId() {
//		return paymentId;
//	}
//
//	public void setPaymentId(int paymentId) {
//		this.paymentId = paymentId;
//	}

//	public double getEarning() {
//		return earning;
//	}
//
//	public void setEarning(double earning) {
//		this.earning = earning;
//	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
     

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getAccountNumber() { 
		return accountNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

//	  public int getArtistId() {
//			return artistId;
//		}
//
//		public void setArtistId(int artistId) {
//			this.artistId = artistId;
//		}

//	public BankDetails getBankDetails() {
//		return bankDetails;
//	}
//
//	public void setBankDetails(BankDetails bankDetails) {
//		this.bankDetails = bankDetails;
//	}
    
    // getters and setters
    
}