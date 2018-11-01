package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public int add(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2;
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public int subtract(@PathVariable int num1, @PathVariable int num2) {
        return num2 - num1;
    }

    @GetMapping("/multiple/{n1}/and/{n2}")
    @ResponseBody
    public int multiply(@PathVariable int n1, @PathVariable int n2) {
        return n1 * n2;
    }

    @GetMapping("/divide/{n1}/by/{n2}")
    @ResponseBody
    public double divide(@PathVariable double n1,@PathVariable double n2) {
        return n1 / n2;
    }
}
