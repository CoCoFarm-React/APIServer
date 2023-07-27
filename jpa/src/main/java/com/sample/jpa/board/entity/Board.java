package com.sample.jpa.board.entity;

import com.sample.jpa.member.entity.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@ToString(exclude = "member")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode( exclude = "member")
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

}
