package com.ridango.game;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HighScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int score;

    public Long getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }
    // Getters and setters
}
