package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.JpaMemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    // private final MemoryMemberRepository repository = new MemoryMemberRepository();
    private final JpaMemberRepository repository;

    public MemberService(JpaMemberRepository repository) {
        this.repository = repository;
    }

    public Long memberJoin(Member member) {
        // 중복 가입 체크
        Optional<Member> findMember = repository.findByName(member.getName());
        if (findMember.isEmpty()) {
            repository.save(member);
            return member.getId();
        } else {
            throw new IllegalStateException("duplicate member");
        }
    }

    public List<Member> findMembers() {
        return repository.findAll();
    }

    public Optional<Member> findById(long memberId) {
        return repository.findById(memberId);
    }

    public Optional<Member> findByName(String name) {
        return repository.findByName(name);
    }
}
