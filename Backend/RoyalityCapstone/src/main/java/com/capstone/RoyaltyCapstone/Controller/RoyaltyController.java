package com.capstone.RoyaltyCapstone.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.RoyaltyCapstone.Service.RoyaltyService;

@RestController
public class RoyaltyController {

    @Autowired
    private RoyaltyService royaltyService;

    @GetMapping("/royalty/{songId}")
    public double getRoyalty(@PathVariable Long songId) {
        return royaltyService.calculateRoyalty(songId);
    }
}
