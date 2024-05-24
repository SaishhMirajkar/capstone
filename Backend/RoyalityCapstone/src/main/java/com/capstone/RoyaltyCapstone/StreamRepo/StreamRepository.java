package com.capstone.RoyaltyCapstone.StreamRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.RoyaltyCapstone.Streams.Streams;

public interface StreamRepository extends JpaRepository<Streams, Long> {
    Streams findBySongId(Long songId);
}

