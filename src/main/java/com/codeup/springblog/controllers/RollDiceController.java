package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String index() {
        return "roll";
    }

    @GetMapping("/roll-dice/{n}")
    public String guess(@PathVariable int n, Model model) {
        int random = (int )(Math.random() * 6 + 1);
        model.addAttribute("roll", random);
        model.addAttribute("guess", n);

        return "guess";
    }
}
