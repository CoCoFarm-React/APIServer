// package com.project.apiserver.repository;

// import java.util.List;

<<<<<<< HEAD
import com.project.apiserver.member.dto.MemberPageRequestDTO;
import com.project.apiserver.member.entity.MemberAccount;
import com.project.apiserver.member.entity.MemberRole;
import com.project.apiserver.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

=======
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import com.project.apiserver.member.entity.Member;
// import com.project.apiserver.member.entity.MemberRole;
// import com.project.apiserver.member.repository.MemberRepository;
>>>>>>> 56ed950fb1dada711163e9c3882d3ed3afe9d0a9

// import jakarta.transaction.Transactional;
// import lombok.extern.log4j.Log4j2;

<<<<<<< HEAD




@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
=======
// @SpringBootTest
// @Log4j2
// public class MemberRepositoryTests {
>>>>>>> 56ed950fb1dada711163e9c3882d3ed3afe9d0a9
    
//     @Autowired
//     private MemberRepository repository;

<<<<<<< HEAD
    @Test
    public void insertTest(){

        for(int i = 0; i<100; i++){
        MemberAccount member = MemberAccount.builder()
        .email("aaa" +i+"@email.com")
        .pw("1111")
        .nickname("nickname"+ i)
        .intro("자소개" + i)
        .build();

        switch(i%2){

            case 0:
                member.addRole(MemberRole.FARMER);
            break;
            case 1:
                member.addRole(MemberRole.CONSUMER);
            break;
        }
        
        repository.save(member);
        }
    }
=======
//     // @Test
//     // public void insertTest(){

//     //     for(int i = 0; i<100; i++){
//     //     Member member = Member.builder()
//     //     .email("aaa" +i+"@email.com")
//     //     .pw("1111")
//     //     .nickname("nickname"+ i)
//     //     .build();

//     //     switch(i%2){

//     //         case 0:
//     //         member.addRole(MemberRole.FARMER);
//     //         break;
//     //         case 1:
//     //         member.addRole(MemberRole.CONSUMER);
//     //         break;
//     //     }
        
//     //     repository.save(member);
//     //     }
//     // }
>>>>>>> 56ed950fb1dada711163e9c3882d3ed3afe9d0a9


//     @Test
//     @Transactional
//     public void readTest(){

<<<<<<< HEAD
        // List<MemberAccount> list = repository.findAll();
        // log.info(list);
        // log.info("----------");
        // list.forEach(mb ->log.info(mb.getRole()));
        
        //List<MemberAccount> list = repository.findByRole(MemberAccountRole.CONSUMER);

        //log.info(list);
        //list.forEach(MemberAccount->log.info(MemberAccount.getRole()));
    }


    @Test
    @Transactional
    public void getSearchList(){

        MemberPageRequestDTO MemberAccountPageRequestDTO = new MemberPageRequestDTO(1,10);

        repository.searchMember();
    
    }
}
=======
//         // List<Member> list = repository.findAll();
//         // log.info(list);
//         // log.info("----------");
//         // list.forEach(mb ->log.info(mb.getRole()));
        
//         List<Member> list = repository.findByRole(MemberRole.CONSUMER);

//         log.info(list);
//         list.forEach(member->log.info(member.getRole()));
//     }
// }
>>>>>>> 56ed950fb1dada711163e9c3882d3ed3afe9d0a9
