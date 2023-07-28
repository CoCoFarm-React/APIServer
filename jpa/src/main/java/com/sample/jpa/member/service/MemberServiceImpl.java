package com.sample.jpa.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.jpa.member.entity.Member;
import com.sample.jpa.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl  implements MemberService{

    private final MemberRepository repository;


    
}
