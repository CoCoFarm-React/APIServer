package com.sample.jpa.member.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import lombok.*;


@Entity
@Table(name = "member")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(of = {"email"})
public class Member extends BaseEntity {
    
    @Id
    private String email;
    private String pw;
    private String nick;
    private int rolecode;
    
}
