package com.example.Travel_Guessing_Game.Dtos;

public class ClueValidationRequest {
    private Long clueId;
    private Long cityId;

    public ClueValidationRequest() {}

    public ClueValidationRequest(Long clueId, Long cityId) {
        this.clueId = clueId;
        this.cityId = cityId;
    }

    // Getters
    public Long getClueId() {
        return clueId;
    }

    public Long getCityId() {
        return cityId;
    }
}
