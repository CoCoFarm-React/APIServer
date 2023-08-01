package com.project.apiserver.board.controller;


import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apiserver.board.dto.BoardListDTO;
import com.project.apiserver.board.dto.BoardReadDTO;
import com.project.apiserver.board.service.BoardService;
import com.project.apiserver.common.PageRequestDTO;
import com.project.apiserver.common.PageResponseDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/board/")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("{bno}")
    public BoardReadDTO getOne(@PathVariable("bno") Long bno){

        return boardService.getOne(bno);
    }
    
    @GetMapping("list")
    public PageResponseDTO<BoardListDTO> getList(PageRequestDTO requestDTO){
        
        return boardService.getList(requestDTO);
    }

    @PostMapping("")
    public Map<String,String> regist(BoardReadDTO boardReadDTO){

        boardService.registBoard(boardReadDTO);

        return Map.of("result", "success");
    }
}
