package com.sample.jpa.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.jpa.board.entity.Board;
import com.sample.jpa.board.repository.BoardRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {


    private final BoardRepository boardRepository;

    @Override
    public List<Board> getBoardList() {

        return boardRepository.findAll();

    }


    
}
