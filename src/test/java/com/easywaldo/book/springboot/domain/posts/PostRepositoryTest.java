package com.easywaldo.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    public PostRepository _postRepository;

    @After
    public void cleanUp() {
        _postRepository.deleteAll();
    }

    @Test
    public void get_posts_all_should_returns_correcty() {

        // Arrange
        String title = "test title";
        String content = "test content";
        String author = "test author";

        // Act
        _postRepository.save(Posts.builder()
            .title(title)
            .content(content)
            .author((author))
            .build());

        // Assert
        List<Posts> result =  _postRepository.findAll();
        Posts data = result.get(0);
        assertThat(data.getTitle()).isEqualTo(title);
        assertThat(data.getContent()).isEqualTo(content);
        assertThat(data.getAuthor()).isEqualTo(author);
    }
}
