package com.sample.jpa.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.jpa.board.entity.Board;
import com.sample.jpa.board.repository.BoardRepository;
import com.sample.jpa.member.entity.Member;
import com.sample.jpa.member.repository.MemberRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired(required = false)
    private BoardRepository boardRepository;


    Member member = Member.builder().email("aaa0@email.com").build();      
    @Test
    public void putBoardList(){
     
        for(int i = 0; i < 30 ; i++){
                
            Board board = Board.builder()
            .content("contents" + i)
            .title("title" +  i)
            .member(member)
            .build();
            
            boardRepository.save(board);
        }
    }


    
}
