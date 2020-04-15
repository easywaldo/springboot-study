package com.easywaldo.book.springboot.service;

import com.easywaldo.book.springboot.domain.cache.CustomCache;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CachingService {

    private final List<CustomCache> _cache = new ArrayList();

    public void AddCache(String keyName, Object data) throws Exception {
        if (this.GetCount() == 100) {
            throw new Exception();
        }
        _cache.add(new CustomCache(keyName, data));
    }

    public Object GetCache(String keyName) {
        if (_cache.size() == 0) return  null;

        Object result = _cache.stream()
                .filter(c -> c.getKey() == keyName)
                .findFirst().get();

        CustomCache cachedData = (CustomCache)result;
        Duration duration = Duration.between(cachedData.getCachedTime(), LocalDateTime.now());

        if (duration.getSeconds() > 100) {
            this.RemoveCache(keyName);
            return null;
        }
        return cachedData.getValue();
    }

    public void RemoveCache(String keyName) {
        _cache.removeIf(c -> c.getKey() == keyName);
    }

    public int GetCount() {
        if (_cache == null) return 0;
        return _cache.size();
    }
}