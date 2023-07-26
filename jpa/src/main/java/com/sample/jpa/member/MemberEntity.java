package com.sample.jpa.member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class MemberEntity {

    
    @Id
    private String email;

}
