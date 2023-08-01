package com.project.apiserver.reply.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.apiserver.reply.dto.ReplyDTO;
import com.project.apiserver.reply.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Query("select new com.project.apiserver.reply.dto.ReplyDTO(r.rno, r.reply, r.ord, r.member.email, r.board.bno, r.regDate, r.modDate) from Reply r left join Member m on m.email = r.member.email where r.board.bno = :bno")
    Page<ReplyDTO> getReplyList(@Param("bno") Long bno, Pageable pageable);

    // 댓글 수 카운트
    @Query("select count(r) from Reply r where r.board.bno = :bno")
    long getCountReply(@Param("bno") Long bno);
    
}
