package com.codeup.springblog.dao.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 98)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Post> posts;

    public User() {
    }

    public User(String username, String email, String password,
                List<Post> posts) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
    }

    public User(User copy) {
        this.id = copy.id;
        this.username = copy.username;
        this.email = copy.email;
        this.password = copy.password;
        this.posts = copy.posts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
