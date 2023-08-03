package com.project.apiserver.member.repository.search;



import com.project.apiserver.member.dto.MemberDTO;
import com.project.apiserver.member.dto.MemberPageRequestDTO;
import com.project.apiserver.member.dto.MemberPageResponseDTO;

public interface MemberSearch {
    
    MemberPageResponseDTO<MemberDTO> searchMember(MemberPageRequestDTO requestDTO);


}
