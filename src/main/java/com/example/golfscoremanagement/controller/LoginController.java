package com.example.golfscoremanagement.controller;

import com.example.golfscoremanagement.form.LoginForm;
import com.example.golfscoremanagement.service.IRoundService;
import com.example.golfscoremanagement.service.IUserService;
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

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoundService roundService;


    @GetMapping("Golf_Manager/index")
    public String index(@ModelAttribute("loginForm") LoginForm loginForm){
        return "index";
    }

    @PostMapping("Golf_Manager/index")
    public String login(@Validated @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, Model model){
        //バリデーション
        if (bindingResult.hasErrors()) {
            return "index";
        }
        var user = userService.findLogin(loginForm.getLoginId(), loginForm.getPassword());
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/Golf_Manager/user/menu";
        }
        model.addAttribute("error", "IDまたはパスワードが不正です");
        return "index";
    }

    @GetMapping("Golf_Manager/user/menu")
    public String UserMenu(Model model) {
        if(session.getAttribute("user") == null) {
            return "redirect:/Golf_Manager/index";
        }
        model.addAttribute("rounds", roundService.findMenu(findUserId(session.getAttribute("user"))));
        model.addAttribute("menu", roundService.findMenuScore(findUserId(session.getAttribute("user"))));
        return "menu";
    }

    @PostMapping("/logout")
    public String logout(@ModelAttribute("loginForm") LoginForm loginForm) {
        session.invalidate();
        return "redirect:/Golf_Manager/index";
    }

    public int findUserId(Object user) {
        var users = userService.findAll();
        for (var target : users) {
            if(target.equals(user)){
                return target.id();
            }
        }
        return -1;
    }
}