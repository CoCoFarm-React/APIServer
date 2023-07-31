package com.project.apiserver.board.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.apiserver.board.entity.Board;
import com.project.apiserver.board.repository.search.BoardSearch;


public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {

    @Query("SELECT b.bno, b.title, b.regDate, m.nickname, c.catename \r\n" + //
            "FROM Board b LEFT JOIN b.member m LEFT JOIN b.category c \r\n" + //
            "WHERE b.bno = :bno \r\n" )
    Object[] getBoard(@Param("bno") Long bno);
    

}
