package com.sample.jpa.member.service;

import java.util.List;

import com.sample.jpa.member.entity.Member;

import jakarta.transaction.Transactional;

@Transactional
public interface MemberService {
    
    List<Member> list(int rolecode);
}
