package com.bullsCows.demo.models;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Random;


@Getter
@Setter
public class Game {
    private int id;
    private String answer; // 4-digit unique number
    public Game() {
        this.answer = generateAnswer();
    }
    private String generateAnswer() {
        Random random = new Random();
        StringBuilder digits = new StringBuilder();
        int i = 0;
        while (i < 4) {
            int digit = random.nextInt(10);
            if (digits.indexOf(String.valueOf(digit)) == -1) {
                digits.append(digit);
                i++;
            }
        }
        return digits.toString();
    }
    
}

