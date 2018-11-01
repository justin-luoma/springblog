package com.codeup.springblog.service;

import com.codeup.springblog.dao.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Deprecated
public class PostService {
    private List<Post> posts;

    public PostService() {
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
}
