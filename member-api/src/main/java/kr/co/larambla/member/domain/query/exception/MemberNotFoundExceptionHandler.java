/*
 * Copyright 2021 ROCKSEA. All rights Reserved.
 * ROCKSEA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package kr.co.larambla.member.domain.query.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class MemberNotFoundExceptionHandler {
    @ExceptionHandler({MemberNotFoundException.class})
    public Mono<ResponseEntity<String>> memberNotFoundException(MemberNotFoundException e) {
        return Mono.just(ResponseEntity.notFound().build());
    }
}
