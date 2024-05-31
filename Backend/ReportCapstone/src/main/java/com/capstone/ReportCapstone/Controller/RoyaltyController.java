package com.capstone.ReportCapstone.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.RoyaltyCapstone.Service.RoyaltyService;

@RestController
@RequestMapping("royalty")
public class RoyaltyController {

    @Autowired
    private RoyaltyService royaltyService;

    @GetMapping("/{songId}")
    public double getRoyalty(@PathVariable Long songId) {
        return royaltyService.calculateRoyalty(songId);
    }
}
