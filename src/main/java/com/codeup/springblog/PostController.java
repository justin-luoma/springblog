package com.codeup.springblog;

import com.codeup.springblog.dao.model.Post;
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

    @GetMapping("/posts")
    public String postsPage(Model model) {

        List<Post> posts = Arrays.asList(
                new Post("Post #1", "Content for post 1"),
                new Post("Post #2", "Content for post 2")
        );

        model.addAttribute("posts", posts);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postPage(@PathVariable int id, Model model) {
        model.addAttribute("post", new Post("Single Page Post Title", "Post body content."));
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
