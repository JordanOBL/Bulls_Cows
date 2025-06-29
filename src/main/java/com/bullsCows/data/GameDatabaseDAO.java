package com.bullsCows.data;

import com.bullsCows.models.Game;
import com.bullsCows.models.Guess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.support.GeneratedKeyHolder;

@Repository
class GameDatabaseDAO implements GameDAO {

  @Autowired
  private final JdbcTemplate jdbcTemplate;

  public GameDatabaseDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Game newGame(Game game) {
    final String sql = "INSERT INTO game VALUES(?,?);";
    return game;
    
  }

 
}
