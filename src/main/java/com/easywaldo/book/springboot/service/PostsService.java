package com.easywaldo.book.springboot.service;

import com.easywaldo.book.springboot.domain.posts.PostsRepository;
import com.easywaldo.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    @Autowired
    private final PostsRepository _postRepository;

    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto) {
        return _postRepository.save(postsSaveRequestDto.toEntity()).getId();
    }
}