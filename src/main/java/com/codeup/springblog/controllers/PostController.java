package com.codeup.springblog.controllers;

import com.codeup.springblog.dao.model.Post;
import com.codeup.springblog.dao.repository.PostRepo;
import com.codeup.springblog.dao.repository.UserRepo;
import com.codeup.springblog.service.PostService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {
    private final PostRepo postRepo;
    private final UserRepo userRepo;

    public PostController(PostRepo postRepo, UserRepo userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/posts")
    public String postsPage(Model model) {
        model.addAttribute("posts", postRepo.findAll());

        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postPage(@PathVariable long id, Model model) {
        model.addAttribute("post", postRepo.findOne(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String createPage(Model model) {
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPage(@PathVariable long id, Model model) {
        model.addAttribute("post", postRepo.findOne(id));
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {
        post.setUser(userRepo.findOne(1L));
        Post newPost = postRepo.save(post);
        return "redirect:/posts/" + newPost.getId();
    }

    @PostMapping("/posts/delete")
    public String delete(@RequestParam("id") long id) {
        postRepo.delete(id);
        return "redirect:/posts";
    }
}
