package com.example.Travel_Guessing_Game.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Clue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String clue;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false) // Foreign key reference
    private Citydetail cityDetail;
}
