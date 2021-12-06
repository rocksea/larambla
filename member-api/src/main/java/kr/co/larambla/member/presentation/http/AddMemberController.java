/*
 * Copyright 2021 ROCKSEA. All rights Reserved.
 * ROCKSEA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package kr.co.larambla.member.presentation.http;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import kr.co.larambla.core.cqrs.command.CommandHandler;
import kr.co.larambla.member.domain.command.AddNewMember;
import kr.co.larambla.member.presentation.http.vo.MemberParam;

@RestController
@RequestMapping(value = "/")
public class AddMemberController {
    final CommandHandler<AddNewMember> addNewMemberCommandHandler;

    public AddMemberController(CommandHandler<AddNewMember> addNewMemberCommandHandler) {
        this.addNewMemberCommandHandler = addNewMemberCommandHandler;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addMember(@Valid @RequestBody MemberParam memberParam) {
        AddNewMember addNewMember =
                AddNewMember.builder().name(memberParam.getName()).age(memberParam.getAge()).build();
        addNewMemberCommandHandler.handle(addNewMember);
    }
}
