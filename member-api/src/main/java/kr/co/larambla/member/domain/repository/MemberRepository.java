/*
 * Copyright 2021 ROCKSEA. All rights Reserved.
 * ROCKSEA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package kr.co.larambla.member.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.larambla.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {}
