package com.easywaldo.book.springboot;

import com.easywaldo.book.springboot.domain.posts.Posts;
import com.easywaldo.book.springboot.domain.posts.PostsRepository;
import com.easywaldo.book.springboot.service.PostsService;
import com.easywaldo.book.springboot.web.PostsApiController;
import com.easywaldo.book.springboot.web.dto.PostsSaveRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;
//import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @Test
    public void post_save_should_correctly() throws Exception {

        // arrange
        PostsSaveRequestDto testDto = new PostsSaveRequestDto("test", "sample", "waldo");

        String url = "http://localhost:" + port + "/api/v1/posts";

        // act
        ResponseEntity<Long> resultEntity = restTemplate.postForEntity(url, testDto, Long.class);

        // assert
        assertThat(resultEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultEntity.getBody()).isGreaterThan(0L);
        List<Posts> list = postsRepository.findAll();
        assertThat(list.get(0).getTitle()).isEqualTo("test");
        assertThat(list.get(0).getContent()).isEqualTo("sample");


//        RequestBuilder reqBuilder = MockMvcRequestBuilders.post(
//                "/api/v1/posts", Posts.builder()
//                        .title("hello")
//                        .content("this is title")
//                        .author("waldo")
//                        .build()).contentType(MediaType.APPLICATION_JSON);

//        this.mvc.perform(reqBuilder).andExpect((status().isOk()));
    }

}
