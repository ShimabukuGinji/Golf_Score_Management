package com.example.golfscoremanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("Golf_Manager/user/add")
    public String user_add() {
        return "user_add";
    }

    @PostMapping("Golf_Manager/user/add")
    public String user_add(Model model) {
        return "user_add";
    }

    @GetMapping("Golf_Manager/user/update")
    public String user_update() {
        return "user_update";
    }

    @PostMapping("Golf_Manager/user/update")
    public String user_update(Model model) {
        return "user_update";
    }

}