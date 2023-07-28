package com.project.apiserver.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apiserver.member.dto.MemberDTO;
import com.project.apiserver.member.service.MemberService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/member/")
@RequiredArgsConstructor
@CrossOrigin
public class MemberContoller {


    private final MemberService memberService;


    @GetMapping("list")
    public List<MemberDTO> getList(){


        return memberService.getList();

    }
    
}
