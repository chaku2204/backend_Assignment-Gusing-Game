package com.example.Travel_Guessing_Game.Repositery;

import com.example.Travel_Guessing_Game.Model.Clue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClueRepositiery extends JpaRepository<Clue,Long> {
}
