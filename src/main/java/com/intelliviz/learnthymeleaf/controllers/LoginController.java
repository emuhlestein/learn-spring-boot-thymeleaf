package com.intelliviz.learnthymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginView() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLoginRequest(@RequestParam String name, @RequestParam String password) {
        System.out.println("Name: " + name);
        System.out.println("Password: " + password);
        return "welcome";
    }
}
