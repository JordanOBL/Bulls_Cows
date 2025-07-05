package com.bullsCows.demo.service;


import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.bullsCows.demo.data.GameDAO;
import com.bullsCows.demo.models.Game;

@Service
public class GameService {
    private final GameDAO dao;

    public GameService(GameDAO dao) {
        this.dao = dao;
    }

    public Integer createGame() {
        Game game = new Game();
        Integer id = this.dao.addGame(game);
        return id;
    }

    public ArrayList<Game> getAllGames() {
        ArrayList<Game> games = this.dao.getAllGames();
        return games;
    }

    public String checkGuess(int id, String guess) {
        String answer = this.dao.getGameAnswer(id);
        System.out.println("Guess: " + guess);
        System.out.println("Answer: " + answer); // <- Check this!

        if (answer == null || answer.length() < 4 || guess == null || guess.length() < 4) {
            throw new IllegalArgumentException("Guess or answer is invalid.");
        }

        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == answer.charAt(i)) {
                bulls++;
            } else if (answer.indexOf(guess.charAt(i)) > -1) {
                cows++;
            }
        }

        return String.format("%d bulls, %d cows", bulls, cows);
    }
}
    

