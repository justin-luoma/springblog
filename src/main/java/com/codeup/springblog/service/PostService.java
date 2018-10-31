package com.codeup.springblog.service;

import com.codeup.springblog.dao.model.Post;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;

    public PostService() {
        createPosts();
    }

    public PostService(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> findAll() {
        return this.posts;
    }

    public Post findOne(long id) {
        return posts.get((int)id - 1);
    }

    public void save(Post post) {
        this.posts.add(post);
    }

    private void createPosts() {
        this.posts = Arrays.asList(
                new Post("Post #1", "Content for post 1"),
                new Post("Post #2", "Content for post 2"),
                new Post("Post #3", "Content for post 3")
        );
    }
}
