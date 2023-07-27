package com.sample.jpa.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.jpa.board.entity.Board;

import jakarta.transaction.Transactional;

@Transactional
public interface BoardRepository extends JpaRepository<Board , Long>  {
    
}
