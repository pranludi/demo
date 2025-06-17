package com.example.demo.config;

import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import com.example.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanConfig {

    // this line is MemberService
//    @Bean
//    public MemberService getMemberService() {
//        return new MemberService();
//    }

    // MemberRepository
//    @Bean
//    public MemberRepository getMemberRepository() {
//        return new MemoryMemberRepository();
//    }
}
