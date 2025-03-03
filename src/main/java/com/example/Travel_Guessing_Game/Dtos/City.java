package com.example.Travel_Guessing_Game.Dtos;

public class City{
     private String city;
     private Long cityId;

     public City(String city, Long city_id){
         this.city = city;
         this.cityId = city_id;
     }

     public String getCity(){
         return this.city;
     }

     public Long getCityId(){
         return  this.cityId;
     }
}
