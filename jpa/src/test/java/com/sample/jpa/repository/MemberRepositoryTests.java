package com.sample.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.jpa.member.entity.Member;
import com.sample.jpa.member.repository.MemberRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
 
    @Autowired(required = false)
    private MemberRepository repository;

    @Test
    public void insertTest(){

        log.info("Start insert");

        for(int i=0; i< 20; i++){
            
            Member member = Member.builder()
            .email("aaa"+ i + "@email.com" )
            .pw("111")
            .nick("nick" +i)
            .rolecode(i%3)
            .build();

            repository.save(member);
        }
        log.info("finish insert");
    }

    @Test
    public void readListTestByRoleCode(){
        
        int cultivator = 1;
        int consumer = 2;
        //List<Member> list = repository.findAll();

        //log.info(list);
        List<Member> culList = repository.findByRolecode(cultivator);
        log.info(culList);

        log.info("-----------------------------------------------------------");
        
        List<Member> conList = repository.findByRolecode(consumer);
        log.info(conList);
        log.info("-------------------------------------------------------------");
        log.info("END");
    }
    
}
