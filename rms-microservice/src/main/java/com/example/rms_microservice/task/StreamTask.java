package com.example.rms_microservice.task;


import com.example.rms_microservice.model.Stream;
import com.example.rms_microservice.model.Song;
import com.example.rms_microservice.repository.SongRepository;
import com.example.rms_microservice.service.StreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Component
public class StreamTask {

	  @Autowired
	    private SongRepository songRepository;

	    @Autowired
	    private StreamService streamService;

	    private Random random = new Random();

	    @Scheduled(fixedRate = 300000)
	    public void generateStreamData() {
	        LocalDate latestDate = streamService.findLatestStreamDate();
	        List<Song> songs = songRepository.findAll();
	        
	        for (Song song : songs) {
	            Long songId = song.getSongId();
	            Stream latestStream = streamService.findLatestStreamBySongId(songId).orElse(null);

	            LocalDate newDate = (latestStream == null) ? latestDate.plusDays(1) : latestStream.getDate().plusDays(1);

	            long randomStreams = random.nextInt(100000);
	            double royalty = streamService.calculateRoyalty(randomStreams);

	            Stream newStream = new Stream();
	            newStream.setDate(newDate);
	            newStream.setSongId(songId);
	            newStream.setStreams(randomStreams);
	            newStream.setRoyalty(royalty);

	            streamService.saveStream(newStream);
	        }
    }
}

