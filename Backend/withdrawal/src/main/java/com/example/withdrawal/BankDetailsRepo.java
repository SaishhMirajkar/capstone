package com.example.withdrawal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDetailsRepo extends JpaRepository<BankDetails, String> {
	
	//public BankDetails findByaccountNumber(String accountNo);
	
}
