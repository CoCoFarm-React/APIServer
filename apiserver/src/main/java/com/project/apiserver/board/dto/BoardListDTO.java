package com.project.apiserver.board.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
@ToString
@NoArgsConstructor
//@Builder
public class BoardListDTO {

    private Long bno;
    private String title;
    
    private String email;
    private String nickname;
    private String catename;
    private Long rcnt;

    private Integer cateno;

    



    public Long getBno() {
        return bno;
    }





    public String getTitle() {
        return title;
    }





    public String getEmail() {
        return email;
    }





    public String getNickname() {
        return nickname;
    }





    public String getCatename() {
        return catename;
    }





    public Long getRcnt() {
        return rcnt;
    }





    public Integer getCateno() {
        return cateno;
    }





    public LocalDateTime getRegDate() {
        return regDate;
    }





    public BoardListDTO(Long bno, String title, String email, String nickname, String catename, Long rcnt,
            Integer cateno, LocalDateTime regDate) {
        this.bno = bno;
        this.title = title;
        this.email = email;
        this.nickname = nickname;
        this.catename = catename;
        this.rcnt = rcnt;
        this.cateno = cateno;
        this.regDate = regDate;
    }





    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;
    

}
