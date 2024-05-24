package com.capstone.ArtistCapstone.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.capstone.ArtistCapstone.Entities.ArtistEntity;
import com.capstone.ArtistCapstone.Repositories.ArtistRepository;
import com.capstone.ArtistCapstone.Entities.ManagerEntity;

@Service
public class ArtistService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ArtistRepository artistRepository;

	private final String managerServiceUrl = "http://manager-service-url";

	public ArtistEntity getArtistWithManager(int artistId) {
		// Fetch artist details from the database
		ArtistEntity artist = artistRepository.findById(artistId).orElseThrow();

		// Fetch manager details from Manager microservice
		String url = managerServiceUrl + "/managers/" + artist.getManager().getManagerId();
		ManagerEntity manager = restTemplate.getForObject(url, ManagerEntity.class);

		// Set manager details in the artist entity
		artist.setManager(manager);

		return artist;
	}
}
