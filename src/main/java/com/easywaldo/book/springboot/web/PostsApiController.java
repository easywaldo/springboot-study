package com.easywaldo.book.springboot.web;

import com.easywaldo.book.springboot.service.PostsService;
import com.easywaldo.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    @Autowired
    private PostsService _postsService;

    @PostMapping("/api/v1/posts")
    @RequestMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return _postsService.save(requestDto);
    }
}
