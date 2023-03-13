package com.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crud.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
