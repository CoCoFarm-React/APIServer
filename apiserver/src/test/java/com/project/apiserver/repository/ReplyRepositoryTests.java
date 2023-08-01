package com.project.apiserver.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.project.apiserver.board.entity.Board;
import com.project.apiserver.member.entity.Member;
import com.project.apiserver.reply.entity.Reply;
import com.project.apiserver.reply.repository.ReplyRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {
    
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void replyInsertTest(){

        Board board = Board.builder().bno(100L).build();
        Member member = Member.builder().email("aaa0@email.com").build();

        for(int i=0; i<100; i++) {

            Reply reply = Reply.builder()
                .reply("test reply" + i)
                .ord(false)
                .board(board)
                .member(member)
                .build();

            replyRepository.save(reply);

        }
    }

    @Test
    public void replyListTest(){

        Board board = Board.builder().bno(100L).build();

        Pageable pageable = PageRequest.of(0, 20, Sort.by("rno").ascending());

        Page<Object[]> replyPage = replyRepository.getReplyList(board.getBno(), pageable);
        List<Object[]> replyList = replyPage.getContent();

        // for (Object[] objects : replyList) {
        //     log.info(objects[0]);
        //     log.info(objects[1]);


        // }

        // log.info(replyPage);
        // log.info(replyList);

    }


}
