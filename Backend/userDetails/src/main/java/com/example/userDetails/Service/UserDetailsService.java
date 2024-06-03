package com.example.userDetails.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userDetails.Repositories.ManagerRepository;
import com.example.userDetails.Repositories.UserDetailsDTO;
import com.example.userDetails.Repositories.UserRepository;
import com.example.userDetails.model.Artist;
import com.example.userDetails.model.Manager;
import com.example.userDetails.model.User;
import com.example.userDetails.Repositories.ArtistRepository;


@Service
public class UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ArtistRepository artistRepository;
    
    @Autowired
    private ManagerRepository managerRepository;

//    public UserDetailsDTO getUserDetailsByUserId(Long userId) {
//        Optional<User> userOptional = userRepository.findById(userId);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            Artist artist = artistRepository.findByUser(user);
//            Manager manager = managerRepository.findByUser(user);
//            return new UserDetailsDTO(user, artist, manager);
//        }
//        return null;
//    }
    public UserDetailsDTO getUserDetailsByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Artist artist = artistRepository.findByUser(user);
            Manager manager = managerRepository.findByUser(user);
            
            String detailType = null;
            if (artist != null) {
                detailType = "artist";
            } else if (manager != null) {
                detailType = "manager";
            }
            
            return new UserDetailsDTO(user, artist, manager, detailType);
        }
        return null;
    }
    
//    public UserDetailsDTO getUserDetailsByUserId(Long userId) {
//        Optional<User> userOptional = userRepository.findById(userId);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            Artist artist = artistRepository.findByUser(user);
//            Manager manager = managerRepository.findByUser(user);
//
//            String detailType = null;
//            List <Long> artistIds = null;
//
//            if (artist != null) {
//                detailType = "artist";
//            } else if (manager != null) {
//                detailType = "manager";
//                artistIds = artistRepository.findAllByManagerId(manager.getManagerid()).stream()
//                                            .map(Artist::getArtistid)
//                                            .collect(Collectors.toList());
//            }
//
//            return new UserDetailsDTO(user, artist, manager, detailType, artistIds);
//        }
//        return null;
//    }



    public Artist updateArtistDetails(Long userId, Artist artistDetails) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Artist artist = artistRepository.findByUser(user);
            if (artist != null) {
                artist.setCountry(artistDetails.getCountry());
                artist.setPhone_no(artistDetails.getPhone_no());
                return artistRepository.save(artist);
            }
        }
        return null;
    }

    public Manager updateManagerDetails(Long userId, Manager managerDetails) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Manager manager = managerRepository.findByUser(user);
            if (manager != null) {
                manager.setManager_name(managerDetails.getManager_name());
                manager.setCountry(managerDetails.getCountry());
                manager.setPhone(managerDetails.getPhone());
                return managerRepository.save(manager);
            }
        }
        return null;
    }
    
    public User updateUserEmail(Long userId, String email) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setEmailid(email);
            return userRepository.save(user);
        }
        return null;
    }
}
