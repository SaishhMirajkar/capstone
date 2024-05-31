package com.RoyalityManagement.ArtistRequest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RoyalityManagement.ArtistRequest.Entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist,Long>{

}
