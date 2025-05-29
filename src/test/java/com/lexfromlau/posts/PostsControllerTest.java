package com.lexfromlau.posts;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@WebMvcTest(PostsController.class)
public class PostsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PostRepository postRepository;

    private List<Post> posts;

    @BeforeEach
    void setUp() {
        posts = List.of(
                new Post(1, 1, "first", "This is the first post", null),
                new Post(2, 2, "second", "This is the second post", null));
    }

    @Test
    void shouldFindAllPosts() throws Exception {
        when(postRepository.findAll()).thenReturn(posts);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/posts"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
