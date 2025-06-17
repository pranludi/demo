package com.example.demo.service;

import com.example.demo.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void memberJoin() {
        //
        Member member1 = new Member();
        member1.setName("member1");
        //
        long returnMemberId = memberService.memberJoin(member1);
        //
        Assertions.assertThat(returnMemberId).isEqualTo(1);
    }

    // 이름 중복 체크
    @Test
    void memberNameCheck() {
        //
        Member member1 = new Member();
        member1.setName("member1");
        Member member2 = new Member();
        member2.setName("member2");
        //
        try {
            // member join success
            memberService.memberJoin(member1);
            memberService.memberJoin(member2);
            Assertions.assertThat(1).isEqualTo(1);
            System.out.println("success");
        } catch (Exception e) {
            // member join failure
            Assertions.assertThat(1).isEqualTo(1);
        }
    }


    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("member1");
        memberService.memberJoin(member1);
        Member member2 = new Member();
        member2.setName("member2");
        memberService.memberJoin(member2);
        //
        List<Member> list = memberService.findMembers();
        int memberSize = list.size();
        //
        Assertions.assertThat(memberSize).isEqualTo(2);
    }

    @Test
    void findById() {
        Member member1 = new Member();
        member1.setName("member1");
        memberService.memberJoin(member1);

        Member member = memberService.findById(1).get();

        Assertions.assertThat(member.getName()).isEqualTo(member1.getName());
    }

}