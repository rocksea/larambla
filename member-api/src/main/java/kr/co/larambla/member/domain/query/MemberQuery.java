/*
 * Copyright 2021 ROCKSEA. All rights Reserved.
 * ROCKSEA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package kr.co.larambla.member.domain.query;

import org.springframework.stereotype.Service;

import kr.co.larambla.member.domain.query.exception.MemberNotFoundException;
import kr.co.larambla.member.domain.Member;
import kr.co.larambla.member.domain.repository.MemberRepository;

@Service
public class MemberQuery {
    final MemberRepository memberRepository;

    public MemberQuery(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberQueryResult getMemberById(Integer id) {
        Member member =
                memberRepository
                        .findById(id)
                        .orElseThrow(() -> new MemberNotFoundException("회원이 존재하지 않습니다."));
        MemberQueryResult memberQueryResult =
                MemberQueryResult.builder()
                        .id(member.getId())
                        .name(member.getName())
                        .age(member.getAge())
                        .build();
        return memberQueryResult;
    }
}
