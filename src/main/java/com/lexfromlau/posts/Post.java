package com.lexfromlau.posts;

public record Post(Integer id, Integer userId, String title, String body, Integer version) {
}
