package com.codeup.springblog;

import com.codeup.springblog.dao.model.Post;
import com.codeup.springblog.service.PostService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String postsPage(Model model) {
        model.addAttribute("posts", postService.findAll());

        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postPage(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPage() {
        return "view the form for creating a post" ;
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "create a new post";
    }
}
