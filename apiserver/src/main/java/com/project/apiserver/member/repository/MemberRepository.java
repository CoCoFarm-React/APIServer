package com.project.apiserver.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.apiserver.member.entity.Member;
import com.project.apiserver.member.entity.MemberRole;
import com.project.apiserver.member.repository.search.MemberSearch;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberSearch{

    // 쿼리 메소드
    // @EntityGraph(attributePaths = "role")
    // List<Member> findByRole(MemberRole role);

}
