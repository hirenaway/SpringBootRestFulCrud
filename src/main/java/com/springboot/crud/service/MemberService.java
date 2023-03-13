package com.springboot.crud.service;

import java.util.List;

import com.springboot.crud.model.Member;

public interface MemberService {

	void delete(Long id);

	Member save(Member member);

	Member updateMemberById(Long id, Member member);

	Member get(Long id);

	List<Member> listAll();
}
