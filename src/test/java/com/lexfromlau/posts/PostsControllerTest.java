package com.lexfromlau.posts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PostsController.class)
@AutoConfigureMockMvc
public class PostsControllerTest {

    @Autowired
    MockMvc mockMvc;

    List<Post> posts = new ArrayList<>();

    @BeforeEach
    void setUp() {
        posts = List.of(
                new Post(1, 1, "first", "This is the first post", null),
                new Post(2, 2, "second", "This is the second post", null));
    }

    @Test
    public void shouldFindAllPosts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/posts")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
