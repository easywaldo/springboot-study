package com.easywaldo.book.springboot.web;

import com.easywaldo.book.springboot.domain.posts.Posts;
import com.easywaldo.book.springboot.service.PostsService;
import com.easywaldo.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/api/v1/delete/{id}")
    @RequestMapping("/api/v1/delete/{id}")
    public void delete(@PathVariable Long id) { _postsService.delete(id); }

    @GetMapping("/api/v1/posts/all")
    public List<Posts> selectAllPosts() {
        return _postsService.selectAllPosts();
    }


}
