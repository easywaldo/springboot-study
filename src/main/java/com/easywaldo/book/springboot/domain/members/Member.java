package com.easywaldo.book.springboot.domain.members;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Member {

    private String Name;

    private UUID Id;

    private String FirstAddress;

    private String SecondAddress;

    @Builder
    public Member(UUID id, String name, String firstAddress, String secondAddress) {
        this.Name = name;
        this.Id = id;
        this.FirstAddress = firstAddress;
        this.SecondAddress = secondAddress;
    }
}
