package com.bullsCows.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Getter
@Setter
public class Game {
    private int id;
    private List<Integer> answer; // 4-digit unique number
    private int rounds;
    private String status; // "In Progress" or "Finished"
    private List<Guess> guesses;

    public Game() {
        this.answer = generateAnswer();
        this.rounds = 1;
        this.status = "In Progress";
        this.guesses = new ArrayList<>();
    }

    private List<Integer> generateAnswer() {
        Random random = new Random();
        Set<Integer> digits = new HashSet<>();
        while (digits.size() < 4) {
            digits.add(random.nextInt(10));
        }
        return new ArrayList<>(digits);
    }
}

