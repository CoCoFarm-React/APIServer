package com.project.apiserver.member.repository.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.project.apiserver.board.dto.BoardListDTO;
import com.project.apiserver.board.entity.Board;
import com.project.apiserver.board.entity.QBoard;
import com.project.apiserver.common.PageResponseDTO;
import com.project.apiserver.common.QCategory;
import com.project.apiserver.member.dto.MemberDTO;
import com.project.apiserver.member.dto.MemberPageRequestDTO;
import com.project.apiserver.member.dto.MemberPageResponseDTO;
import com.project.apiserver.member.entity.Member;
import com.project.apiserver.member.entity.QMember;
import com.project.apiserver.reply.entity.QReply;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;

import lombok.extern.log4j.Log4j2;

import com.querydsl.core.types.Projections;

@Log4j2
public class MemberSearchImpl extends QuerydslRepositorySupport implements MemberSearch {

        public MemberSearchImpl() {
        super(Member.class);
    }




    @Override
    public MemberPageResponseDTO<MemberDTO> searchMember(MemberPageRequestDTO requestDTO) {

        // log.info("------------------------------1-------------------------------");
        // Pageable pageable = makePageable(requestDTO);

        // QMember member = QMember.member;
        // String type = requestDTO.getType();
        // String keyword = requestDTO.getKeyword();
        // JPQLQuery<Member> searchQuery = from(member);
        // log.info("------------------------------2-------------------------------");
        // if(type != null && keyword != null){
            
        //     BooleanBuilder searchBuilder = new BooleanBuilder();
        //     searchBuilder.or(member.nickname.contains(keyword));

        //     searchQuery.where(searchBuilder);
        // }
        // log.info("------------------------------3-------------------------------");
        //  this.getQuerydsl().applyPagination(pageable, searchQuery);
        // log.info("------------------------------4-------------------------------" + this.getQuerydsl().applyPagination(pageable, searchQuery));
       
       
        // return null;




        Pageable pageable = makePageable(requestDTO);
        QMember qMember = QMember.member;

        // String keyword = requestDTO.getKeyword();
        String keyword = "1";
        // String searchType = requestDTO.getType();

        JPQLQuery<Member> searchQuery = from(qMember); 
        
        log.info("--------------------------------------2");
        
        // searchQuery.where(qMember.category.cateno.eq(cateno1));
        searchQuery.where(qMember.nickname.contains(keyword));
        
        log.info("-------------------------------------3");

        // if (keyword != null && searchType != null) {
        //     // tc => [t,c]
        //     String[] searchArr = searchType.split("");
        //     // BooleanBuilder 생성
        //     BooleanBuilder searchBuilder = new BooleanBuilder();         
        //     for (String typeword : searchArr) {

        //     } // end for
        //       // for문 끝난후 where 로 searchBuilder 추가
        //     searchQuery.where(searchBuilder);
        // }
        
        log.info("--------------------------------------");
        this.getQuerydsl().applyPagination(pageable, searchQuery);

        // searchQuery.groupBy(qMember);

        JPQLQuery<BoardListDTO> listQuery = searchQuery.select(Projections.bean(
                BoardListDTO.class,
                qMember.email,
                qMember.nickname,
                qMember.regDate
                ));
                        
        long totalCount = listQuery.fetchCount();
        List<BoardListDTO> list = listQuery.fetch();
        log.info("==================================================");
        log.info(list);
        log.info("==================================================");



        return null;
        // return new MemberPageResponseDTO<>(list, totalCount, requestDTO);


    }
    
}
