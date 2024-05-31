package com.RoyalityManagement.ArtistRequest.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RoyalityManagement.ArtistRequest.Entity.Artist;
import com.RoyalityManagement.ArtistRequest.Repo.ArtistRepository;

@RestController
@RequestMapping("/artists")
@CrossOrigin(origins = "http://localhost:3000")
public class ArtistController {
	
	 
    @Autowired
    private ArtistRepository artistRepository;


	@PutMapping("/{artistId}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long artistId, @RequestBody Map<String, Long> updates) {
        return artistRepository.findById(artistId)
                .map(artist -> {
                    Long managerId = updates.get("managerId");
                    if (managerId != null) {
                        artist.setManagerid(managerId);
                        artistRepository.save(artist);
                    }
                    return ResponseEntity.ok(artist);
                }).orElse(ResponseEntity.notFound().build());
    }
}
