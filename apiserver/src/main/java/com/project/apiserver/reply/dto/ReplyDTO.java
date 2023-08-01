package com.project.apiserver.reply.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.apiserver.board.entity.Board;
import com.project.apiserver.member.entity.Member;

import groovy.transform.ToString;
import groovy.transform.builder.Builder;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ReplyDTO {
    
    private Long rno;
    private String reply;
    @Builder.Default
    private boolean ord = false;
    
    private String email;
    private Long bno;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modDate;

}
