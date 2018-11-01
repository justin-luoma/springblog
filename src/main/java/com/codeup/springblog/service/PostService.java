package com.codeup.springblog.service;

import com.codeup.springblog.dao.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        if(post.getId() > this.posts.size()) {
            this.posts.add(post);
        } else {
            this.posts.remove((int)(post.getId() - 1));
            this.posts.add(post);
        }
    }

    private void createPosts() {
        this.posts = new ArrayList<>(3);
        this.posts.add(new Post(1, "Post #1", "Content for post 1"));
        this.posts.add(new Post(2, "Post #2", "Content for post 2"));
        this.posts.add(new Post(3, "Post #3", "Content for post 3"));
    }
}
