package com.example.Travel_Guessing_Game.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
    private String email;
    private String password;
    private String username;
}
