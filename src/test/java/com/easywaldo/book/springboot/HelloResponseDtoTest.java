package com.easywaldo.book.springboot;

import com.easywaldo.book.springboot.web.HelloResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.contentOf;
import static org.hamcrest.Matchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloResponseDtoTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void sut_should_operates_correctly() {
        // Arrange
        String expectedName = "test";
        int expectedAmount = 1000;

        // Act
        HelloResponseDto dto = new HelloResponseDto(expectedName, expectedAmount);

        // Assert
        assertThat(dto.getName()).isEqualTo(expectedName);
        assertThat(dto.getAmount()).isEqualTo(expectedAmount);
    }

    @Test
    public void hello_dto_action_should_returns_ok() throws  Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string((hello)));
    }

    @Test
    public void hello_dto_action__should_returns_correctly() throws Exception {
        String name = "hello";
        int amount = 2000;

        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}
