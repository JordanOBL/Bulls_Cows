package com.bullsCows.demo.controllers;

import com.bullsCows.demo.data.GameDAO;
import com.bullsCows.demo.models.Game;
import com.bullsCows.demo.service.GameService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/game")
public class GameController {
  @Autowired
  private final GameService service;

  public GameController(GameService service) {
    this.service = service;
  }
  
  @GetMapping("/begin")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Integer> createNewGame() {
    int id = this.service.createGame();
    return ResponseEntity.ok(id);
  }

  @GetMapping("/games")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ArrayList<Game>> getAllGames() {
    ArrayList<Game> games = this.service.getAllGames();
    System.out.println(games);
    return ResponseEntity.ok(games);
  } 

  @PostMapping("/{id}/guess")
  public ResponseEntity<String> makeGuess(@PathVariable int id, @RequestBody String guess) {
    String guessResult = this.service.checkGuess(id, guess);
      
      return ResponseEntity.ok(guessResult);
  }
}
