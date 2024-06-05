package com.example.golfscoremanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ScoreController {
    @GetMapping("Golf_Manager/score/add")
    public String score_add() {
        return "user_add";
    }

    @PostMapping("Golf_Manager/score/add")
    public String score_add(Model model) {
        return "user_add";
    }
}