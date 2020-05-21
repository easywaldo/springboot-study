package com.easywaldo.book.springboot.service;

import com.easywaldo.book.springboot.domain.posts.Posts;
import com.easywaldo.book.springboot.domain.posts.PostsRepository;
import com.easywaldo.book.springboot.web.dto.PostsResponseDto;
import com.easywaldo.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
        Long id = _postRepository.save(postsSaveRequestDto.toEntity()).getId();
        this.addCachePost(postsSaveRequestDto, id);
        return id;
    }

    @CachePut(cacheNames = "posts", key = "#id")
    private void addCachePost(PostsSaveRequestDto postsSaveRequestDto, Long id) { }

    @CacheEvict(cacheNames = "posts", key = "#id")
    private void deleteCachePost(Long id) { }

    @Transactional
    @CachePut(cacheNames = "posts", key = "#id")
    public PostsResponseDto update(Long id, PostsSaveRequestDto postsSaveRequestDto) {
        Posts posts = _postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not exists post. id=" + id));

        posts.Update(postsSaveRequestDto.getTitle(), postsSaveRequestDto.getContent());
        return new PostsResponseDto(posts);
    }

    @Transactional
    @CacheEvict(cacheNames = "posts", key = "#postId")
    public void delete(Long postId) {
        _postRepository.deleteById(postId);
    }

    public List<Posts> selectAllPosts() {
//        for(String name:_cacheManager.getCacheNames()){
//            _cacheManager.getCache(name).clear();
//        }
        return _postRepository.findAll();
    }

    @Cacheable(cacheNames = "posts", key = "#id")
    public PostsResponseDto getPost(Long id) {
        Posts entity = _postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not exists post. id=" + id));

        return new PostsResponseDto(entity);
    }
}