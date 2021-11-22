/*
 * Copyright 2021 ROCKSEA. All rights Reserved.
 * ROCKSEA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package kr.co.larambla.member.presentation.http;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.larambla.member.application.query.MemberQuery;
import kr.co.larambla.member.application.query.MemberQueryResult;
import reactor.core.publisher.Mono;

@RestController
public class MemberQueryController {
    final MemberQuery memberQuery;

    public MemberQueryController(MemberQuery memberQuery) {
        this.memberQuery = memberQuery;
    }

    @GetMapping("/")
    public Mono<String> getHello() {
        return Mono.just("Hello world");
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<MemberQueryResult>> getMember(@PathVariable("id") Integer id) {
        return Mono.just(ResponseEntity.ok().body(memberQuery.getMemberById(id)));
    }
}
