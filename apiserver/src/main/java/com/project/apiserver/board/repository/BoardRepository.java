package com.project.apiserver.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.apiserver.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
    
}
