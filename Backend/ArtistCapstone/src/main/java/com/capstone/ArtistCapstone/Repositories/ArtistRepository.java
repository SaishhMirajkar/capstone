package com.capstone.ArtistCapstone.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capstone.ArtistCapstone.Entities.ArtistEntity;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Integer> {
}
