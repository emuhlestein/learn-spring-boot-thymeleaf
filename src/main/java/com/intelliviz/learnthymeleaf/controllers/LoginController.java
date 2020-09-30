package com.intelliviz.learnthymeleaf.controllers;

import com.intelliviz.learnthymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {

    @ModelAttribute
    public void addAttributes(Model model) {
        System.out.println("Adding attributes");
    }

    @GetMapping("/login")
    public String showLoginView(Model model) {
        System.out.println("showLoginView");
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/welcome")
    public String showWelcomeView(@RequestParam(required = false) String username, Model model) {
//        model.addAttribute("user", new User(username, ""));
        model.addAttribute("names", List.of("ed", "ben", "bobi"));
        model.addAttribute("username", username);
        return "welcome";
    }

    @PostMapping("/login")
//    public String handleLoginRequest(@RequestParam String name, @RequestParam String password, Model model) {
    public String handleLoginRequest(@ModelAttribute User user, Model model) {

//        model.addAttribute("user", new User())
        if(!user.getUsername().equals("emuhlestein") || !user.getPassword().equals("password")) {
            model.addAttribute("errorMessage", "Invalid credentials");
            return "login";
        }
        model.addAttribute("user", new User(user.getUsername(), user.getPassword()));
        System.out.println("Name: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        return "welcome";
    }
}
