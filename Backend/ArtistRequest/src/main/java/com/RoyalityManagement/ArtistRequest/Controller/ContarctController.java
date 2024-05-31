
package com.RoyalityManagement.ArtistRequest.Controller;

import java.util.List;
import java.util.Map;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RoyalityManagement.ArtistRequest.Entity.Contract;
import com.RoyalityManagement.ArtistRequest.Repo.ContractRepository;
import com.RoyalityManagement.ArtistRequest.Service.ContractService;

@RestController
@RequestMapping("/contracts")
@CrossOrigin(origins = "http://localhost:3000")
public class ContarctController {
	
	
	 	@Autowired
	    private ContractService contractService;
	 	
	 	@Autowired
	 	private ContractRepository contractRepository;
 
	    @PostMapping("/save")
	    public Contract saveContract(@RequestBody Contract contract) {
	    	System.out.println(contract);
	        return contractService.saveContract(contract);
	    }
	    
	    @GetMapping("/pending/{managerId}")
	    public ResponseEntity<List<Contract>> getPendingContracts(@PathVariable Long managerId) {
	    	List<Contract> contracts = contractService.getContractsByManagerId(managerId);
	        return ResponseEntity.ok(contracts);
	    }
	    
	    @PutMapping("/{contractId}")
	    public ResponseEntity<Contract> updateContract(@PathVariable Long contractId, @RequestBody Map<String, String> updates) {
	        return contractRepository.findById(contractId)
	                .map(contract -> {
	                    String status = updates.get("status");
	                    if (status != null) {
	                        contract.setStatus(status);
	                        contractRepository.save(contract);
	                    }
	                    return ResponseEntity.ok(contract);
	                }).orElse(ResponseEntity.notFound().build());
	    }
	    
	 
	    @DeleteMapping("/{contractId}")
	    public ResponseEntity<String> deleteContract(@PathVariable Long contractId) {
	        try {
	            contractService.deleteContract(contractId);            
	            return ResponseEntity.ok("Contract deleted successfully.");
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body("Contract not found.");
	        }
	    }
	   
	}
	    
	    
	    

