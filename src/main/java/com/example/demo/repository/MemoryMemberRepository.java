package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // member data storage
    private static long sequence = 0L; // member id

    @Override
    public Member save(Member member) {
        sequence = sequence + 1;
        member.setId(sequence);
        store.put(sequence, member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.of(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values() // map values
                .stream() // java stream function
                .filter(member -> member.getName().equals(name))
                .findAny(); // get data
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
