package com.project.apiserver.board.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.apiserver.board.dto.BoardReadDTO;
import com.project.apiserver.board.entity.Board;
import com.project.apiserver.board.repository.search.BoardSearch;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {

    @Query("select new com.project.apiserver.board.dto.BoardReadDTO(b.bno, b.title, b.content, m.email, m.nickname, c.catename, b.category.cateno, b.regDate, b.modDate) from Board b left join b.member m left join b.category c where b.bno = :bno")
    BoardReadDTO getBoardInfo(@Param("bno") Long bno);
    

}
