package com.springboot.crud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.model.Member;
import com.springboot.crud.repository.MemberRepository;

@Transactional
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}

	@Override
	public Member save(Member member) {
		return memberRepository.save(member);
	}

	@Override
	public Member get(Long id) {
		Optional<Member> m = memberRepository.findById(id);
		if(m.isPresent()) {
			return m.get();
		}
		return null;
	}

	@Override
	public List<Member> listAll() {
		return memberRepository.findAll();
	}

	@Override
	public Member updateMemberById(Long id, Member member) {
		Optional<Member> m = memberRepository.findById(id);
		if(m.isPresent()) {
			Member presentMember = m.get();
			presentMember.setMemberLocation(member.getMemberLocation());
			presentMember.setMemberName(member.getMemberName());
			memberRepository.save(presentMember);
		}
		return null;
	}

}
