package com.example.Travel_Guessing_Game.Repositery;

import com.example.Travel_Guessing_Game.Model.Citydetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityDetailRepository extends JpaRepository<Citydetail, Long> {
    @Query(value = "SELECT * FROM citydetail ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Citydetail> findRandomCity();

}

