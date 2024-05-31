package com.RoyaltyManagement.ManagerRequest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoyaltyManagement.ManagerRequest.Entity.Artist;
import com.RoyaltyManagement.ManagerRequest.Repo.ArtistRepository;


@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getArtistsWithNullManagerid() {
        return artistRepository.findByManageridIsNull();
    }
    

}
