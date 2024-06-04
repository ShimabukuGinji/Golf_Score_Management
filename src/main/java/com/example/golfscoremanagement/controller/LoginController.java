package com.example.golfscoremanagement.controller;

import com.example.golfscoremanagement.form.LoginForm;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private HttpSession session;

    @GetMapping("Golf_Score_Management/login")
    public String index(@ModelAttribute("loginForm") LoginForm loginForm){
        return "index";
    }

    @GetMapping("Golf_Score_Management/menu")
    public String menu() {
        return "menu";
    }
}