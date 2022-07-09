package ru.kata.spring.boot_security.demo.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;


@Controller
@RequestMapping("/")
public class UserController {


    @GetMapping("user")
    public String showUser(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "users/userPage";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }
}