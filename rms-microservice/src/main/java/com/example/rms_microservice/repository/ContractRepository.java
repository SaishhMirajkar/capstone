package com.example.rms_microservice.repository;

import com.example.rms_microservice.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findByArtistIdAndStatus(Long artistId, String status);
    Optional<Contract> findByArtistId(Long artistId);
   
}
