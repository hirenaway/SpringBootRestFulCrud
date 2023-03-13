package com.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.model.Member;
import com.springboot.crud.service.MemberService;

@RestController
@RequestMapping("/api")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/members")
	public List<Member> getAllMembers() {
		return this.memberService.listAll();
	}

	@GetMapping("/member/{id}")
	public ResponseEntity<Member> getAllMembers(@PathVariable Long id) {
		try {
			Member member = memberService.get(id);
			return new ResponseEntity<>(member, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addmember")
	public void addMember(@RequestBody Member member) {
		memberService.save(member);
	}

	@PutMapping("/updatemember/{id}")
	public ResponseEntity<?> updateMember(@RequestBody Member member, @PathVariable Long id) {
		try {
			memberService.updateMemberById(id, member);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deletemember/{id}")
	public void deleteMember(@PathVariable Long id) {
		memberService.delete(id);
	}


}
