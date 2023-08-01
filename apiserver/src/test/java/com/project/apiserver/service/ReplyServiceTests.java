package com.project.apiserver.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.apiserver.reply.dto.ReplyDTO;
import com.project.apiserver.reply.service.ReplyService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyServiceTests {
    

    @Autowired
    private ReplyService replyService;

    @Test
    public void insertTests(){

        ReplyDTO dto = ReplyDTO.builder()
        .reply("insert Service Test")
        .build();

        log.info(dto);

        log.info(replyService.insertOne(dto));
    
    }
}
