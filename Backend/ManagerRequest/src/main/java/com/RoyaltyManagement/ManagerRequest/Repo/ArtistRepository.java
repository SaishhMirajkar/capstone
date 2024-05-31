package com.RoyaltyManagement.ManagerRequest.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RoyaltyManagement.ManagerRequest.Entity.Artist;


public interface ArtistRepository extends JpaRepository<Artist,Long>{

	  List<Artist> findByManageridIsNull();
}
