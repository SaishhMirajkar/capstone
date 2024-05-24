package com.capstone.RoyaltyCapstone.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.RoyaltyCapstone.StreamRepo.StreamRepository;
import com.capstone.RoyaltyCapstone.Streams.Streams;

@Service
public class RoyaltyService {
    private static final double TIER_1_RATE = 0.002;
    private static final double TIER_2_RATE = 0.005;
    private static final double TIER_3_RATE = 0.01;
    private static final long TIER_1_THRESHOLD = 10000;
    private static final long TIER_2_THRESHOLD = 50000;

    @Autowired
    private StreamRepository streamRepository;

    public double calculateRoyalty(Long songId) {
        Streams stream = streamRepository.findBySongId(songId);
        if (stream == null) {
            throw new RuntimeException("Song not found");
        }
        long streams = stream.getStreams();
        double royalty = 0.0;
        if (streams <= TIER_1_THRESHOLD) {
            royalty = streams * TIER_1_RATE;
        } else if (streams <= TIER_2_THRESHOLD) {
            royalty = TIER_1_THRESHOLD * TIER_1_RATE + (streams - TIER_1_THRESHOLD) * TIER_2_RATE;
        } else {
            royalty = TIER_1_THRESHOLD * TIER_1_RATE + (TIER_2_THRESHOLD - TIER_1_THRESHOLD) * TIER_2_RATE
                    + (streams - TIER_2_THRESHOLD) * TIER_3_RATE;
        }
        return royalty;
    }
}
