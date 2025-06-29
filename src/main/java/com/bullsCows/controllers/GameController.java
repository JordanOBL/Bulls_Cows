package com.bullsCows.controllers;

import com.bullsCows.models.Game;
import com.bullsCows.models.Guess;
import com.bullsCows.data.GameDAO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/game")
public class GameController {

  private final GameDAO dao;

  public GameController(GameDAO dao) {
    this.dao = dao;
  } 

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Game newGame() {
    Game game = new Game();
    return dao.newGame(game);
  }


 
}
