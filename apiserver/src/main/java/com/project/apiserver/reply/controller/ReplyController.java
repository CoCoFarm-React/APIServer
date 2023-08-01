package com.project.apiserver.reply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.apiserver.common.PageResponseDTO;
import com.project.apiserver.reply.dto.ReplyDTO;
import com.project.apiserver.reply.dto.ReplyPageRequestDTO;
import com.project.apiserver.reply.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("api/replies/")
@CrossOrigin
public class ReplyController {


    private final ReplyService replyService;

    @GetMapping("{bno}/list")
    public PageResponseDTO<ReplyDTO> repliseList(@PathVariable("bno") Long bno, ReplyPageRequestDTO requestDTO){

        
        

        log.info(replyService.replyList(requestDTO));
        return  replyService.replyList(requestDTO);

    }

    
}
