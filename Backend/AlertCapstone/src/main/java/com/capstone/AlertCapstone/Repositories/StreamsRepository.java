package com.capstone.AlertCapstone.Repositories;

import com.capstone.AlertCapstone.Entities.Streams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamsRepository extends JpaRepository<Streams, Long> {
    Streams findTopByOrderByStreamsDesc();
}
