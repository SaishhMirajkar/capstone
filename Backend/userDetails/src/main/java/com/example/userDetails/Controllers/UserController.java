package com.example.userDetails.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userDetails.Repositories.UserDetailsDTO;
import com.example.userDetails.Service.UserDetailsService;
import com.example.userDetails.model.Artist;
import com.example.userDetails.model.Manager;
import com.example.userDetails.model.User;

@CrossOrigin(value="http://localhost:3000")
@RestController
@RequestMapping("/api/user-details")
public class UserController {

	    @Autowired
	    private UserDetailsService userDetailsService;


	    @GetMapping("/{userId}")
	    public ResponseEntity<UserDetailsDTO> getUserDetailsByUserId(@PathVariable Long userId) {
	        UserDetailsDTO userDetails = userDetailsService.getUserDetailsByUserId(userId);
	        if (userDetails != null) {
	            return ResponseEntity.ok(userDetails);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
//	    @PutMapping("/{userId}")
//	    public ResponseEntity<User> updateUserDetails(@PathVariable Long userId, @RequestBody User userDetails) {
//	        User updatedUser = userDetailsService.updateUserDetails(userId, userDetails);
//	        if (updatedUser != null) {
//	            return ResponseEntity.ok(updatedUser);
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }

	    @PutMapping("/artists/{userId}")
	    public ResponseEntity<Artist> updateArtistDetails(@PathVariable Long userId, @RequestBody Artist artistDetails) {
	        Artist updatedArtist = userDetailsService.updateArtistDetails(userId, artistDetails);
	        if (updatedArtist != null) {
	            return ResponseEntity.ok(updatedArtist);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PutMapping("/managers/{userId}")
	    public ResponseEntity<Manager> updateManagerDetails(@PathVariable Long userId, @RequestBody Manager managerDetails) {
	        Manager updatedManager = userDetailsService.updateManagerDetails(userId, managerDetails);
	        if (updatedManager != null) {
	            return ResponseEntity.ok(updatedManager);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    @PutMapping("/{userId}/email")
	    public ResponseEntity<User> updateUserEmail(@PathVariable Long userId, @RequestBody User userDetails) {
	        User updatedUser = userDetailsService.updateUserEmail(userId, userDetails.getEmailid());
	        if (updatedUser != null) {
	            return ResponseEntity.ok(updatedUser);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

}
