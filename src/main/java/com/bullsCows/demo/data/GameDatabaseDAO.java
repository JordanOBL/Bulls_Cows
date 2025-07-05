package com.bullsCows.demo.data;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.bullsCows.demo.models.Game;


@Repository
class GameDatabaseDAO implements GameDAO {

  @Autowired
  private final JdbcTemplate jdbc;

  public GameDatabaseDAO(JdbcTemplate jdbcTemplate) {
    this.jdbc = jdbcTemplate;
  }

 @Override
 public Integer addGame(Game game) {
   String sql = "INSERT INTO game(answer) VALUES (?)";

   GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

   jdbc.update(connection -> {
     PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
     ps.setString(1, game.getAnswer());
     return ps;
   }, keyHolder);

   return keyHolder.getKey().intValue();
 }

 @Override
 public ArrayList<Game> getAllGames() {
     String sql = "SELECT * FROM game";
     List<Game> games = jdbc.query(sql, (rs, rowNum) -> {
         Game game = new Game();
         game.setId(rs.getInt("id"));
         game.setAnswer(rs.getString("answer"));
       
         return game;
     });
 
     return new ArrayList<Game>(games);
 }

 @Override
 public String getGameAnswer(int id) {
   final String sql = "SELECT answer FROM game WHERE id = ?;";
   String answer = jdbc.queryForObject(sql, String.class, id);
   return answer;
  
 }
}
