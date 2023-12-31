package com.project.apiserver.board.controller;

import java.util.Map;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@CrossOrigin
public class BoardController {

    private final BoardService boardService;

    // 하나만
    @GetMapping("{bno}")
    public BoardReadDTO getOne(@PathVariable("bno") Long bno) {

        return boardService.getOne(bno);
    }

    // 전체 리스트 및 검색
    @GetMapping("list")
    public PageResponseDTO<BoardListDTO> getList(
            // queryString 값으로 받아옴
            @ParameterObject PageRequestDTO requestDTO) {

        requestDTO.setCategory(
                requestDTO.getCateno() == null || requestDTO.getCateno() <= 0 ? 5 : requestDTO.getCateno());
        return boardService.getList(requestDTO);
    }

    // 게시글 등록
    @PostMapping("")
    public Map<String, String> registBoard(BoardReadDTO boardReadDTO) {

        boardService.registBoard(boardReadDTO);
        return Map.of("result", "success");
    }

    // 게시글 삭제
    @DeleteMapping("{bno}")
    public Map<String, String> deleteBoard(@PathVariable("bno") Long bno) {

        boardService.deleteBoard(bno);

        return Map.of("result", "success");
    }

    // 게시글 수정
    @PutMapping("")
    public Map<String, String> modifyBoard(BoardReadDTO boardReadDTO) {

        boardService.modifyBoard(boardReadDTO);

        return Map.of("result", "success");
    }
}
