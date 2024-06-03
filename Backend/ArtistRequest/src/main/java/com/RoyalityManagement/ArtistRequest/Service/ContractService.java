package com.RoyalityManagement.ArtistRequest.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoyalityManagement.ArtistRequest.APPLICATION_CONSTANT;
import com.RoyalityManagement.ArtistRequest.Entity.Contract;
import com.RoyalityManagement.ArtistRequest.Repo.ContractRepository;


@Service
public class ContractService {
 
	@Autowired
    private ContractRepository contractRepository;
 
    public Contract saveContract(Contract contract) {
    	contract.setStatus(APPLICATION_CONSTANT.PENDING);
        return contractRepository.save(contract);
    }
    
//    public List<Contract> getContractsByManagerId(Long managerId) {
//    	 return contractRepository.findByManagerId(managerId);
//    }
    
    public void deleteContract(Long contractId) {         
    	contractRepository.findById(contractId)                 
    	.ifPresent(contractRepository::delete);     
    	}
    
    public List<Contract> getContractsByManagerId(Long managerId) {        
    return contractRepository.findContractsByManagerIdAndApproacedByArtist(managerId);     
    }
    
    public void updateContractStatus() {
        LocalDate currentDate = LocalDate.now();
        List<Contract> contracts = contractRepository.findActiveContracts(currentDate);
 
        for (Contract contract : contracts) {
            contract.setContractStatus("active");
            contractRepository.save(contract);
        }
 
        List<Contract> allContracts = contractRepository.findAll();
        for (Contract contract : allContracts) {
            if (!contracts.contains(contract)) {
                contract.setContractStatus("inactive");
                contractRepository.save(contract);
            }
        }
    }
}