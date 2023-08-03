package com.project.apiserver.board.repository.search;

import java.util.List;

import com.project.apiserver.member.entity.QMemberAccount;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import com.project.apiserver.board.dto.BoardListDTO;
import com.project.apiserver.board.entity.Board;
import com.project.apiserver.board.entity.QBoard;
import com.project.apiserver.common.PageRequestDTO;
import com.project.apiserver.common.PageResponseDTO;
import com.project.apiserver.common.QCategory;
<<<<<<< HEAD

=======
import com.project.apiserver.member.entity.QMember;
>>>>>>> 56ed950fb1dada711163e9c3882d3ed3afe9d0a9
import com.project.apiserver.reply.entity.QReply;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public PageResponseDTO<BoardListDTO> search(PageRequestDTO requestDTO) {

        Pageable pageable = makePageable(requestDTO);
        
        QBoard qBoard = QBoard.board;
        QMemberAccount qMember = QMemberAccount.memberAccount;
        QCategory qCategory = QCategory.category;
        QReply qReply = QReply.reply1;
<<<<<<< HEAD

        String keyword = requestDTO.getKeyword();
        String searchType = requestDTO.getType();
        Integer cateno1 = requestDTO.getCateno();
        log.info(cateno1);

        JPQLQuery<Board> searchQuery = from(qBoard);
        
        log.info("--------------------------------------1");
=======
        String keyword = requestDTO.getKeyword();
        String searchType = requestDTO.getType();
        Integer category = requestDTO.getCategory();
    
        JPQLQuery<Board> searchQuery = from(qBoard);
        searchQuery.leftJoin(qMember).on(qMember.eq(qBoard.member));
        searchQuery.leftJoin(qCategory).on(qCategory.eq(qBoard.category));
        searchQuery.leftJoin(qReply).on(qReply.board.eq(qBoard));
>>>>>>> 56ed950fb1dada711163e9c3882d3ed3afe9d0a9

        searchQuery.leftJoin(qBoard.category, qCategory);
        searchQuery.leftJoin(qBoard.member, qMember);
        searchQuery.leftJoin(qReply).on(qReply.board.eq(qBoard));


        log.info("--------------------------------------2");
        
        searchQuery.where(qBoard.category.cateno.eq(cateno1));
        
        log.info("-------------------------------------3");
        if (keyword != null && searchType != null) {
            // tc => [t,c]
            String[] searchArr = searchType.split("");
            // BooleanBuilder 생성
            BooleanBuilder searchBuilder = new BooleanBuilder();         
<<<<<<< HEAD
=======

            if (category != null && category > 0 ) {
                searchBuilder.or(qBoard.category.cateno.eq(category));
            }

>>>>>>> 56ed950fb1dada711163e9c3882d3ed3afe9d0a9
            for (String typeword : searchArr) {

                switch (typeword) {
                    case "t" -> searchBuilder.or(qBoard.title.contains(keyword));
                    case "c" -> searchBuilder.or(qBoard.content.contains(keyword));
                    case "w" -> searchBuilder.or(qBoard.member.nickname.contains(keyword));
                }

            } // end for
              // for문 끝난후 where 로 searchBuilder 추가
            searchQuery.where(searchBuilder);
        }
        
        log.info("--------------------------------------");
        this.getQuerydsl().applyPagination(pageable, searchQuery);



        searchQuery.groupBy(qBoard);
        JPQLQuery<BoardListDTO> listQuery = searchQuery.select(Projections.bean(
                BoardListDTO.class,
                qBoard.bno,
                qBoard.title,
                qMember.email,
                qMember.nickname,
<<<<<<< HEAD
                qBoard.category.catename,
                qBoard.category.cateno,
                qBoard.regDate,
                qReply.countDistinct().as("rcnt")
                ));
                        
=======
                qCategory.catename,
                qBoard.regDate,
                qReply.countDistinct().as("rCnt")
                ));
>>>>>>> 56ed950fb1dada711163e9c3882d3ed3afe9d0a9
        long totalCount = listQuery.fetchCount();
        List<BoardListDTO> list = listQuery.fetch();
        log.info(list);

        return new PageResponseDTO<>(list, totalCount, requestDTO);

    }


    

}
