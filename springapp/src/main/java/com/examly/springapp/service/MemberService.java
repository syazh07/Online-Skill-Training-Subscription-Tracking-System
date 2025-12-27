package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Member;

public interface MemberService {

    Member createMemeber(Member member);

    Member getMemberById(long id);

    Member updateMember(long id, Member updatedMember);

    List<Member> getMembersByPage(int page, int size);
}
