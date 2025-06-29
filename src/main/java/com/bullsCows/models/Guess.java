package com.bullsCows.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Guess {
  private String time; //time of guess
  private String guess; //users guess
  private int exact; //amount of exact numbers in correct position
  private int partial; //amount of correct numbers in incorrect positions
  
  public Guess(String time, String guess, Integer exact, Integer partial){
    this.time = time;
    this.guess = guess;
    this.exact = exact;
    this.partial = partial;
  }

  
}
