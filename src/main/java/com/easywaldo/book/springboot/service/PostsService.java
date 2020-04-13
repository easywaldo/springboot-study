package com.easywaldo.book.springboot.service;

import com.easywaldo.book.springboot.domain.posts.Posts;
import com.easywaldo.book.springboot.domain.posts.PostsRepository;
import com.easywaldo.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RequiredArgsConstructor
@EnableCaching
@Service
public class PostsService {

    @Autowired
    private final PostsRepository _postRepository;

    @Autowired
    private final CacheManager _cacheManager;

    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto) {
        return _postRepository.save(postsSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public void delete(Long postId) {
        _postRepository.deleteById(postId);
    }

    @Cacheable(cacheNames = "selectAllPosts")
    public List<Posts> selectAllPosts() {
        for(String name:_cacheManager.getCacheNames()){
            _cacheManager.getCache(name).clear();
        }

        return _postRepository.findAll();
    }
}