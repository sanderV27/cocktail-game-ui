package com.ridango.game;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HighScoreRepository extends JpaRepository<HighScore, Long> {
    HighScore findTopByOrderByScoreDesc();  // Find the highest score
}
