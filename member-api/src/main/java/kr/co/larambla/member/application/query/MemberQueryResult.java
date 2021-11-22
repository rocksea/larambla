/*
 * Copyright 2021 ROCKSEA. All rights Reserved.
 * ROCKSEA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package kr.co.larambla.member.application.query;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberQueryResult {
    Integer id;
    String name;
    Integer age;
}
