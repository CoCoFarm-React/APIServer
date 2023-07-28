package com.project.apiserver.member.service;

import java.util.List;

import com.project.apiserver.member.dto.MemberDTO;
import jakarta.transaction.Transactional;

@Transactional
public interface MemberService {
    
    List<MemberDTO> getList();
}
