/*
 * Copyright 2021 ROCKSEA. All rights Reserved.
 * ROCKSEA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package kr.co.larambla.member.domain.command;

import kr.co.larambla.core.cqrs.command.Command;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AddNewMember implements Command {
    private Integer id;
    private String name;
    private Integer age;
}
