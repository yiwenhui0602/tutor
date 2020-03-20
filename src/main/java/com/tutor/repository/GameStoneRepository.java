package com.tutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutor.model.GameStoneLog;


@Repository
public interface GameStoneRepository extends JpaRepository<GameStoneLog, Long> {
    
}
