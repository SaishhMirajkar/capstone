package com.example.rms_microservice.repository;


import com.example.rms_microservice.model.Stream;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StreamRepository extends JpaRepository<Stream, Long> {
    Optional<Stream> findTopBySongIdOrderByDateDesc(Long songId);
    Optional<Stream> findTopByOrderByDateDesc();
    
    
}

