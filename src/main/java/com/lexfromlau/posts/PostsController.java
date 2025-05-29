package com.lexfromlau.posts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostsController {

    PostRepository postRepository;

    public PostsController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("")
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }
}
