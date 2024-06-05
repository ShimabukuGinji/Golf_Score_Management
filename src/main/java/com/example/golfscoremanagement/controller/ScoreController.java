package com.example.golfscoremanagement.controller;

import com.example.golfscoremanagement.form.RoundForm;
import com.example.golfscoremanagement.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ScoreController {

    @Autowired
    private ICourseService courseService;

    private List<Integer> years = new ArrayList<>();
    private List<Integer> months = new ArrayList<>();
    private List<Integer> days = new ArrayList<>();

    private ScoreController(){
        for (var i = 1900; i<=2100; i++) {
            this.years.add(i);
        }
        for (var i = 1; i<=12; i++) {
            this.months.add(i);
        }
        for (var i = 1; i<=31; i++) {
            this.days.add(i);
        }
    }

    @GetMapping("Golf_Manager/user/insert")
    public String roundInsert(@ModelAttribute("RoundFrom") RoundForm RoundFrom, Model model) {
        model.addAttribute("courses", courseService.findAll());
        model.addAttribute("years", this.years);
        model.addAttribute("months", this.months);
        model.addAttribute("days", this.days);
        RoundFrom.setPlayDateYear("2024");
        RoundFrom.setPlayDateMonth("6");
        RoundFrom.setPlayDateDay("5");
        return "roundInsert";
    }

    @PostMapping("Golf_Manager/user/insert")
    public String roundInsert(@Validated @ModelAttribute("RoundFrom") RoundForm RoundFrom, BindingResult bindingResult, Model model) {
        //バリデーション
        if(bindingResult.hasErrors()) {

            return "Golf_Manager/user/insert";
        }
        return "user_add";
    }
}