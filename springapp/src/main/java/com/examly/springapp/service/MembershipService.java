package com.examly.springapp.service;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Membership;
import com.examly.springapp.repository.MembershipRepository;

@Service
public class MembershipService {

    private final MembershipRepository membershipRepository;

    // Constructor Injection
    public MembershipService(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    // Save membership plan
    public Membership saveMembership(Membership membership) {
        return membershipRepository.save(membership);
    }

    // Get membership by ID
    public Membership getMembershipById(long id) {
        return membershipRepository.findById(id).orElse(null);
    }
}
