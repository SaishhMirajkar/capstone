package com.RoyaltyManagement.ManagerRequest.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoyaltyManagement.ManagerRequest.APPLICATION_CONSTANT;
import com.RoyaltyManagement.ManagerRequest.Entity.Contract;
import com.RoyaltyManagement.ManagerRequest.Repo.ContractRepository;

@Service
public class ContractService {
 
    @Autowired
    private ContractRepository contractRepository;
 
    public Contract saveContract(Contract contract) {
    	contract.setStatus(APPLICATION_CONSTANT.PENDING);
        return contractRepository.save(contract);
    }
    
    public List<Contract> getContractsByArtistId(Long artistId) {        
        return contractRepository.findContractsByArtistIdAndApproacedByManager(artistId);     
    }

    
    public void deleteContract(Long contractId) {         
    	contractRepository.findById(contractId)                 
    	.ifPresent(contractRepository::delete);     
    	}
    
    public void updateContractStatus() {
        LocalDate currentDate = LocalDate.now();
        List<Contract> contracts = contractRepository.findActiveContracts(currentDate);
 
        for (Contract contract : contracts) {
            contract.setStatus("active");
            contractRepository.save(contract);
        }
 
        List<Contract> allContracts = contractRepository.findAll();
        for (Contract contract : allContracts) {
            if (!contracts.contains(contract)) {
                contract.setStatus("inactive");
                contractRepository.save(contract);
            }
        }
    }
}
