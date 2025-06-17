package com.example.demo;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    void save() {
        //
        Member test1 = new Member();
        test1.setName("test1");
        //
        Member savedMember = repository.save(test1);
        //
        Assertions.assertThat(savedMember.getName()).isEqualTo(test1.getName());
    }
}
