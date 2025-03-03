package com.example.Travel_Guessing_Game.Dtos;

public class ClueDTO {
    private Long id;
    private String clue;

    public ClueDTO(Long id, String clue) {
        this.id = id;
        this.clue = clue;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getClue() {
        return clue;
    }
}
