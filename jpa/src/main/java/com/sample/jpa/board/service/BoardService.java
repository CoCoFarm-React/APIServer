package com.sample.jpa.board.service;

import java.util.List;

import com.sample.jpa.board.entity.Board;

import jakarta.transaction.Transactional;

@Transactional
public interface BoardService {

    List<Board> getBoardList();
    
}
