package com.example.golfscoremanagement.controller;

import com.example.golfscoremanagement.form.LoginForm;
import com.example.golfscoremanagement.service.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {
    @Autowired
    private HttpSession session;

    @Autowired
    private IUserService userService;


    @GetMapping("Golf_Manager/login")
    public String index(@ModelAttribute("loginForm") LoginForm loginForm){
        return "index";
    }

    @GetMapping("Golf_Manager/menu")
    public String menu() {
        var user = userService.findAll();
        session.invalidate();
        session.setAttribute("user", user.get(0));
        return "menu";
    }
}