package com.example.Travel_Guessing_Game.Controllers;

import com.example.Travel_Guessing_Game.Dtos.LoginRequest;
import com.example.Travel_Guessing_Game.Dtos.SignupRequest;
import com.example.Travel_Guessing_Game.Model.User;
import com.example.Travel_Guessing_Game.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private  AuthService authService;



    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody SignupRequest request) {
        Map<String, String> response = authService.registerUser(request.getEmail(), request.getPassword(), request.getUsername());
        return ResponseEntity.ok(response);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = authService.login(request.getIdentifier(), request.getPassword());

        Map<String,String> Maptoken = new HashMap<>();
        if (token != null) {
            Maptoken.put("token",token);
            return ResponseEntity.ok(Maptoken);
        }

        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
