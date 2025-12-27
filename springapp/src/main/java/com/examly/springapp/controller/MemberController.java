package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Member;
import com.examly.springapp.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private final MemberService service;
    
    public MemberController(MemberService service) {
        this.service = service;
    }
     @PostMapping
    public ResponseEntity<Member> createMemeber(@RequestBody Member member) {
        try {
            Member saved = service.createMemeber(member);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable long id){
        try {
            Member member = service.getMemberById(id);
            if(member != null) {
                return ResponseEntity.status(HttpStatus.OK).body(member);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(
            @PathVariable long id, 
            @RequestBody Member updatedMember) {

        try {
            Member member = service.updateMember(id, updatedMember);
            if(member != null) {
                return ResponseEntity.ok(member);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/page/{page}/{size}")
    public List<Member> getMembersByPage(@PathVariable int page, @PathVariable int size){
        return service.getMembersByPage(page,size);
    }
}
