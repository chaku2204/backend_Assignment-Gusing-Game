package com.example.Travel_Guessing_Game.Dtos;

import java.util.List;

import com.example.Travel_Guessing_Game.Model.Citydetail;
import com.example.Travel_Guessing_Game.Model.Funfact;

public class AnswerDto {
    private List<ClueDTO> cluelist;
    @lombok.Getter
    private boolean answer;
    private List<FunfactDto> funFacts;
    public AnswerDto(List<ClueDTO> cluelist, boolean answer, List<FunfactDto> citydetail){
        this.cluelist = cluelist;
        this.answer = answer;
        this.funFacts = citydetail;
    }

    public List<ClueDTO> getCluelist(){
        return this.cluelist;
    }



    public List<FunfactDto> getFunFacts() {
        return funFacts;
    }
}
