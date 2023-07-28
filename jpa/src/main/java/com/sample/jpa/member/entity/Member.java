package com.sample.jpa.member.entity;


import com.sample.jpa.role.MemberRole;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
public class Member extends BaseEntity {
    
    @Id
    private String email;
    private String pw;
    private String nick;
    

    @Enumerated(EnumType.STRING)
    private MemberRole role;
    
}
