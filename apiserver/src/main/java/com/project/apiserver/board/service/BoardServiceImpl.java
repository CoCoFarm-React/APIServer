package com.project.apiserver.board.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apiserver.board.dto.BoardListDTO;
import com.project.apiserver.board.entity.Board;
import com.project.apiserver.board.entity.QBoard;
import com.project.apiserver.board.repository.BoardRepository;
import com.project.apiserver.common.Category;
import com.project.apiserver.common.PageRequestDTO;
import com.project.apiserver.common.PageResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;
    
    @Override
    public PageResponseDTO<BoardListDTO> getList(PageRequestDTO pageRequestDTO) {
        
        return boardRepository.search(pageRequestDTO);
    }

    @Override
    public BoardListDTO getOne(Long bno) {
       

       

       BoardListDTO board = boardRepository.getBoard(bno);

        return null;
        
    }

    

}
