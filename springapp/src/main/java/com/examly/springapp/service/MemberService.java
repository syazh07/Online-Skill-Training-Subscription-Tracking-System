package com.examly.springapp.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Member;
import com.examly.springapp.repository.MemberRepository;

@Service
public class MemberService {
    private final MemberRepository repo;
    
    public MemberService(MemberRepository repo) {
        this.repo = repo;
    }

    public Member createMemeber(Member m){
        return repo.save(m);
    }
    public Member getMemberById(long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
    }

    public Member updateMember(long id, Member updatedMember) {
        return repo.findById(id).map(member -> {
            member.setName(updatedMember.getName());
            member.setEmail(updatedMember.getEmail());
            return repo.save(member);
        }).orElse(null); 
    }

    public List<Member> getMembersByPage(int page,int size){
        Pageable pageable=PageRequest.of(page,size);
        return repo.findAll(pageable).getContent();
    }
}
