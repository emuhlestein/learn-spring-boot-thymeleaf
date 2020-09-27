package com.intelliviz.learnthymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "<h1 style=\"color: green\">Hello World</h1>";
    }
}
