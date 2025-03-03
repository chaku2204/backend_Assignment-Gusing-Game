package com.example.Travel_Guessing_Game.Services;


import com.example.Travel_Guessing_Game.Component.JwtUtil;
import com.example.Travel_Guessing_Game.Model.User;
import com.example.Travel_Guessing_Game.Repositery.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private  UserRepository userRepository;

    private  BCryptPasswordEncoder passwordEncoder;
    private  JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.jwtUtil = jwtUtil;
    }

    public String login(String identifier, String password) {
        Optional<User> userOptional = userRepository.findByEmail(identifier);

        if (userOptional.isEmpty()) {
            userOptional = userRepository.findByUsername(identifier);
        }

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return jwtUtil.generateToken(user.getUsername()); // Use username for token generation
            }
        }
        return null;
    }

    public  Map<String, String> registerUser(String email, String password, String username) {
        Map<String, String> response = new HashMap<>();
        if (userRepository.existsByEmail(email)) {
            response.put("message","Email already registered");
            return response;
        }

        if (userRepository.findByUsername(username).isPresent()) {
            response.put("message","Username already taken, please choose another one.");
            return response;
        }

        if (username == null || username.trim().isEmpty()) {
            username = generateUniqueUsername(userRepository); // Ensure uniqueness
        }

        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));



        try {
            userRepository.save(user);
            response.put("message", "You have registr with "+email+". "+"You can login with this also "+username+".");
            response.put("username", user.getUsername());
            return response;
        } catch (Exception e) {
            response.put("message", "Error occurred during registration.");
            return response;
        }
    }

    public String generateUniqueUsername(UserRepository userRepository) {
        String username;
        do {
            username = "user_" + UUID.randomUUID().toString().substring(0, 8);
        } while (userRepository.findByUsername(username).isPresent()); // Ensure it's unique
        return username;
    }

}
