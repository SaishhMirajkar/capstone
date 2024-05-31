package com.example.withdrawal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value="http://localhost:3000")
@RestController
@RequestMapping("/bankDetails")
public class BankDetailsController {
	
	@Autowired
	BankDetailsRepo repo;
	
	@CrossOrigin(value="http://localhost:3000")
	@PostMapping("/addBankDetails")
	public ResponseEntity<BankDetails> addDetails(@RequestBody BankDetails bd){
		
		 BankDetails acc = repo.save(bd);
		return new ResponseEntity<>(acc,HttpStatus.OK);
		}


    public List<BankDetails> getAllBankDetails() {
        return repo.findAll();
    }
	
//	@GetMapping("/getBankDetails")
//	public ResponseEntity<BankDetails> get(@PathVariable String accNo){
//		//System.out.println("yoo");
//		//BankDetails acc = repo.findByaccountNumber(accNo);
//		
//		return new ResponseEntity<> (acc,HttpStatus.OK);
//		
//	} 
	
	

}
