package com.capstone.AdminCapstone.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.AdminCapstone.Entities.User;
import com.capstone.AdminCapstone.Repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
   

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public User registerUser(String username, String password, String email, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmailid(email);
        user.setRole(role);
        user.setFirstTimeLogin(true);
        return userRepository.save(user);
    }
    
 
}
