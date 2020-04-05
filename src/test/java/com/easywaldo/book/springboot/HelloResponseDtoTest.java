package com.easywaldo.book.springboot;

import com.easywaldo.book.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

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
}
