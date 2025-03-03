package com.example.Travel_Guessing_Game.Dtos;

public class FunfactDto {
    private Long id;
    private String Funfact;

    public FunfactDto(Long id, String funfact) {
        this.id = id;
        Funfact = funfact;
    }

    public Long getId() {
        return id;
    }

    public String getFunfact() {
        return Funfact;
    }
}
