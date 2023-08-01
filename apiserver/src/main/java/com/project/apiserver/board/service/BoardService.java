package com.project.apiserver.board.service;

import com.project.apiserver.board.dto.BoardListDTO;
import com.project.apiserver.common.PageRequestDTO;
import com.project.apiserver.common.PageResponseDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface BoardService {

   PageResponseDTO<BoardListDTO> getList (PageRequestDTO pageRequestDTO);    

   BoardListDTO getOne(Long bno);
}
