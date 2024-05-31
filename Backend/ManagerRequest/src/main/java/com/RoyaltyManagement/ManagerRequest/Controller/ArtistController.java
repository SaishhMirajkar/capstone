package com.RoyaltyManagement.ManagerRequest.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RoyaltyManagement.ManagerRequest.Entity.Artist;
import com.RoyaltyManagement.ManagerRequest.Repo.ArtistRepository;
import com.RoyaltyManagement.ManagerRequest.Service.ArtistService;



@RestController
@RequestMapping("/artists")
@CrossOrigin(value = "http://localhost:3000/")
public class ArtistController {

    @Autowired
    private ArtistService artistService;
    
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/nullManagerId")
    public ResponseEntity<List<Artist>> getArtistsWithNullManagerId() {
        List<Artist> artists = artistService.getArtistsWithNullManagerid();
        return ResponseEntity.ok(artists);
    }
    
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
