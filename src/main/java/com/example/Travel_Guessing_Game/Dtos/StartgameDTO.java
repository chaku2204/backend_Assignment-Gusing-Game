package com.example.Travel_Guessing_Game.Dtos;

import java.util.List;

public class StartgameDTO {
    private List<ClueDTO> cluelist;
    private List<City> cityList;
    public StartgameDTO(List<ClueDTO> cluelist, List<City> cityList){
        this.cluelist = cluelist;
        this.cityList = cityList;
    }

    public List<ClueDTO> getCluelist(){
        return this.cluelist;
    }

    public List<City> getCityList(){
        return this.cityList;
    }

}
