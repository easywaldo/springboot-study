package com.easywaldo.book.springboot.web.dto;

import com.easywaldo.book.springboot.domain.members.Member;
import lombok.Getter;

import java.util.UUID;

@Getter
public class MemberResponseDto {
    private UUID id;
    private String name;
    private String firstAddress;
    private String secondAddress;

    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.firstAddress = member.getFirstAddress();
        this.secondAddress = member.getSecondAddress();
    }

}
