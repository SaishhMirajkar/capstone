package com.example.userDetails.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.userDetails.model.Artist;
import com.example.userDetails.model.User;

public interface ArtistRepository extends JpaRepository<Artist,Long> {

	Artist findByUser(User user);
	
//	@Query("SELECT a FROM Artist a WHERE a.manager.id = :managerid")
//    List<Artist> findAllByManagerId(@Param("managerid") Long managerid); 

}
