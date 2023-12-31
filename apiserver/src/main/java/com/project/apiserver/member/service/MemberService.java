package com.project.apiserver.member.service;

import java.util.List;

import com.project.apiserver.common.PageResponseDTO;
import com.project.apiserver.member.dto.MemberDTO;
import com.project.apiserver.member.entity.MemberRole;

import jakarta.transaction.Transactional;

@Transactional
public interface MemberService {
    
    List<MemberDTO> getList(MemberRole memberRole);

    MemberDTO getOne(Long mno);


}
