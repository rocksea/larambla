/*
 * Copyright 2021 ROCKSEA. All rights Reserved.
 * ROCKSEA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package kr.co.larambla.member.application.command;

import org.springframework.stereotype.Service;

import kr.co.larambla.core.cqrs.command.CommandHandler;
import kr.co.larambla.member.domain.Member;
import kr.co.larambla.member.domain.repository.MemberRepository;

@Service
public class AddNewMemberHandler implements CommandHandler<AddNewMember> {
    private final MemberRepository memberRepository;

    public AddNewMemberHandler(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void handle(AddNewMember command) {
        Member member = Member.builder().name(command.getName()).age(command.getAge()).build();
        memberRepository.save(member);
    }
}
