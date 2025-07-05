package com.bullsCows.demo.data;

import java.util.ArrayList;

import com.bullsCows.demo.models.Game;


public interface GameDAO {
  public Integer addGame(Game game);

  public ArrayList<Game> getAllGames();
  public String getGameAnswer(int id);
  //public Game getGame(int id);
  //public Game updateGame(Game game);
  //public boolean FinishGame(int id);
}
