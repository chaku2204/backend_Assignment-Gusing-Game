package com.example.Travel_Guessing_Game.Services;


import com.example.Travel_Guessing_Game.Dtos.*;
import com.example.Travel_Guessing_Game.Model.Citydetail;
import com.example.Travel_Guessing_Game.Model.Clue;
import com.example.Travel_Guessing_Game.Model.Funfact;
import com.example.Travel_Guessing_Game.Repositery.CityDetailRepository;
import com.example.Travel_Guessing_Game.Repositery.ClueRepositiery;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
     private CityDetailRepository cityDetailRepository;
    @Autowired
    private ClueRepositiery clueRepositiery;

    public List<ClueDTO> genraterandomeclue(){
        Optional<Citydetail> cityOptional = cityDetailRepository.findRandomCity();
        if (cityOptional.isEmpty()) {
            throw new RuntimeException("No cities found!");
        }
        Citydetail city = cityOptional.get();

        return city.getClues().stream()
                .map(clue -> new ClueDTO(clue.getId(), clue.getClue()))
                .collect(Collectors.toList());


    }

    public AnswerDto checkanswer(ClueValidationRequest request){
        Optional<Clue> clueOptional = clueRepositiery.findById(request.getClueId());
        boolean answer = true;
        if (clueOptional.isEmpty()) {
            answer = false;
        }

        Clue clue = clueOptional.get();
        answer = clue.getCityDetail().getId().equals(request.getCityId());
        List<ClueDTO> clueDTOS = this.genraterandomeclue();
        List<FunfactDto> Funfact = clue.getCityDetail().getFunFacts().stream()
                .map(funfact -> new FunfactDto(funfact.getId(), funfact.getFunfact()))
                .collect(Collectors.toList());

        AnswerDto FinalDto = new AnswerDto(clueDTOS,answer,Funfact);
        return FinalDto;


    }

    public StartgameDTO GetstartGame(){
        StartgameDTO startgameDTO = new StartgameDTO(this.genraterandomeclue(),this.getlistCity());
        return startgameDTO;
    }

    private List<City> getlistCity(){
        List<Citydetail> citydetails = cityDetailRepository.findAll();
        return citydetails.stream().map(city-> new City(city.getCity(),city.getId())).collect(Collectors.toList());
    }
}


