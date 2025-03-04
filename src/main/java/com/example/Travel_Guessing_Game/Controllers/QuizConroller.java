package com.example.Travel_Guessing_Game.Controllers;


import com.example.Travel_Guessing_Game.Dtos.AnswerDto;
import com.example.Travel_Guessing_Game.Dtos.ClueDTO;
import com.example.Travel_Guessing_Game.Dtos.ClueValidationRequest;
import com.example.Travel_Guessing_Game.Dtos.StartgameDTO;
import com.example.Travel_Guessing_Game.Model.Citydetail;
import com.example.Travel_Guessing_Game.Model.Clue;
import com.example.Travel_Guessing_Game.Services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/quiz")
public class QuizConroller {

     private  QuizService quizService;

    public QuizConroller(QuizService quizService) {
        this.quizService = quizService;
    }
  @GetMapping("/random-clues")
   public List<ClueDTO> getrandomeclue(){
        return this.quizService.genraterandomeclue();
  }

  @PostMapping("/random-clues/checkanswer")
    public AnswerDto checkanswer(@RequestBody ClueValidationRequest request){
        System.out.println(request);
     return this.quizService.checkanswer(request);
  }
  @GetMapping("/start-game")
   public StartgameDTO getstartgame(){
        return this.quizService.GetstartGame();
  }
}
