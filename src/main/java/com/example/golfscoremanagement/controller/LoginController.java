package com.example.golfscoremanagement.controller;

import com.example.golfscoremanagement.form.LoginForm;
import com.example.golfscoremanagement.service.IRoundService;
import com.example.golfscoremanagement.service.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private HttpSession session;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoundService roundService;


    @GetMapping("Golf_Manager/index")
    public String index(@ModelAttribute("loginForm") LoginForm loginForm){
        return "index";
    }

    @PostMapping()
    public String login() {
        return "redirect:/index";
    }

    @GetMapping("Golf_Manager/user/menu")
    public String UserMenu(Model model) {
        var user = userService.findAll();
        session.invalidate();
        session.setAttribute("user", user.get(1));
        var rounds = roundService.findMenu(findUserId(session.getAttribute("user")));
        model.addAttribute("rounds", rounds);
        return "menu";
    }

//    @GetMapping("Golf_Manager/admin/menu")
//    public String AdminMenu() {
//        var user = userService.findAll();
//        session.invalidate();
//        session.setAttribute("user", user.get(0));
//        return "menu";
//    }

    private int findUserId(Object user) {
        var users = userService.findAll();
        for (var target : users) {
            if(target.equals(user)){
                return target.id();
            }
        }
        return -1;
    }
}