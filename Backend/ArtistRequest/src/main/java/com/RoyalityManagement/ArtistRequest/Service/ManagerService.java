package com.RoyalityManagement.ArtistRequest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoyalityManagement.ArtistRequest.Entity.Manager;
import com.RoyalityManagement.ArtistRequest.Repo.ManagerRepository;


@Service
public class ManagerService {
	
	

	    @Autowired
	    private ManagerRepository managerRepository;

	    public List<Manager> getAllManagers() {
	        return managerRepository.findAll();
	    }
}
