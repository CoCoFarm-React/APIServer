package com.project.apiserver.member.repository.search;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.project.apiserver.member.dto.MemberDTO;
import com.project.apiserver.member.dto.MemberPageRequestDTO;
import com.project.apiserver.member.dto.MemberPageResponseDTO;

public interface MemberSearch {
    
    MemberPageResponseDTO<MemberDTO> searchMember(MemberPageRequestDTO requestDTO);

    default Pageable makePageable(MemberPageRequestDTO requestDTO){

        Pageable pageable = PageRequest.of(requestDTO.getPage()-1, requestDTO.getSize(),Sort.by("regDate").descending());

        return pageable;
    }
}
