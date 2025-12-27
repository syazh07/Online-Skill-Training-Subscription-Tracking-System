package com.examly.springapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Membership;
import com.examly.springapp.service.MembershipService;

@RestController
@RequestMapping("/api/memberships")
public class MembershipController {

    private final MembershipService membershipService;

    // Constructor Injection
    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    // Create membership plan
    @PostMapping
    public ResponseEntity<Membership> createMembership(@RequestBody Membership membership) {
        Membership savedMembership = membershipService.saveMembership(membership);
        return new ResponseEntity<>(savedMembership, HttpStatus.CREATED);
    }

    // Get membership by ID
    @GetMapping("/{id}")
    public ResponseEntity<Membership> getMembershipById(@PathVariable long id) {
        Membership membership = membershipService.getMembershipById(id);
        if (membership != null) {
            return ResponseEntity.ok(membership);
        }
        return ResponseEntity.notFound().build();
    }
}
