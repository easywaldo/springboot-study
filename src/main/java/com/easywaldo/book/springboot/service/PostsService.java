package com.easywaldo.book.springboot.service;

import com.easywaldo.book.springboot.domain.posts.PostsRepository;
import com.easywaldo.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@Service
public class PostsService {

    @Autowired
    private final PostsRepository _postRepository;

    public PostsService(PostsRepository _repo) {
        _postRepository = _repo;
    }

    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto) {
        return _postRepository.save(postsSaveRequestDto.toEntity()).getId();
    }
}