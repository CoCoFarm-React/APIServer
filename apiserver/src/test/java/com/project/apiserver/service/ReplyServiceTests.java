package com.project.apiserver.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.apiserver.reply.dto.ReplyDTO;
import com.project.apiserver.reply.dto.ReplyPageRequestDTO;
import com.project.apiserver.reply.service.ReplyService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyServiceTests {
    
    @Autowired
    private ReplyService replyService;

    @Test
    public void insertTest(){

        ReplyDTO dto = ReplyDTO.builder().bno(100L).ord(false).reply("대댓글").build();

        replyService.replyRegister(dto);

    }

    @Test
    public void getListTest(ReplyPageRequestDTO requestDTO){

        replyService.replyList(requestDTO);

    }


}