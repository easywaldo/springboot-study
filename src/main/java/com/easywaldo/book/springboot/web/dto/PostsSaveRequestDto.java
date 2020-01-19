package com.easywaldo.book.springboot.web.dto;

import com.easywaldo.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String _title;
    private String _content;
    private String _author;

    @Builder
    public PostsSaveRequestDto(
            String title,
            String content,
            String author) {

        this._title = title;
        this._content = content;
        this._author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(_title)
                .content(_content)
                .author(_author)
                .build();
    }

}
