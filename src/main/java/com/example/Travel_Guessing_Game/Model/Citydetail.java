package com.example.Travel_Guessing_Game.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "citydetail", uniqueConstraints = {
        @UniqueConstraint(columnNames = "city") // Ensure city names are unique
})
public class Citydetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String city;

    @Column(nullable = false)
    private String country;

    @OneToMany(mappedBy = "cityDetail", cascade = CascadeType.ALL)
    private List<Clue> clues;

    @OneToMany(mappedBy = "cityDetail", cascade = CascadeType.ALL)
    private List<Funfact> funFacts;

    @OneToMany(mappedBy = "cityDetail", cascade = CascadeType.ALL)
    private List<Trivia> trivia;

    public void setCity(String city) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City name cannot be null or empty");
        }
        this.city = city.toLowerCase(); // Convert to lowercase before storing
    }
}
