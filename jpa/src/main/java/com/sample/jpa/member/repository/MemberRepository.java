package com.sample.jpa.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.jpa.member.entity.Member;

public interface MemberRepository  extends JpaRepository<Member, String>{
    
   List<Member> findByRolecode(int rolecode);
}
