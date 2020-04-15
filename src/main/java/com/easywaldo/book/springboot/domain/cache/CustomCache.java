package com.easywaldo.book.springboot.domain.cache;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomCache {

    private String key;

    private Object value;

    private LocalDateTime cachedTime;

    @Builder
    public CustomCache(String key, Object value) {
        this.cachedTime = LocalDateTime.now();
        this.key = key;
        this.value = value;
    }
}
