package com.example.Travel_Guessing_Game.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String identifier;
    private String password;
}
