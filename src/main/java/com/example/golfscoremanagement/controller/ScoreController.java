package com.example.golfscoremanagement.controller;

import com.example.golfscoremanagement.entity.Hole;
import com.example.golfscoremanagement.entity.Score;
import com.example.golfscoremanagement.exception.NoSuchPostalCodeException;
import com.example.golfscoremanagement.form.RoundForm;
import com.example.golfscoremanagement.service.ICourseService;
import com.example.golfscoremanagement.service.IRoundService;
import com.example.golfscoremanagement.service.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class ScoreController {

    @Autowired
    private HttpSession session;

    @Autowired
    private ICourseService courseService;
    @Autowired
    private IRoundService roundService;
    @Autowired
    private IUserService userService;

    private final List<Integer> years = new ArrayList<>();
    private final List<Integer> months = new ArrayList<>();
    private final List<Integer> days = new ArrayList<>();
    private List<Hole> round1;
    private List<Hole> round2;
    private final List<String> holeNo1 = List.of("ホール", "Hole1", "Hole2", "Hole3", "Hole4", "Hole5", "Hole6", "Hole7", "Hole8", "Hole9", "IN", "");
    private final List<String> holeNo2 = List.of("ホール", "Hole10", "Hole11", "Hole12", "Hole13", "Hole14", "Hole15", "Hole16", "Hole17", "Hole18", "OUT", "Total");
    private final List<String> scoreNo1 = List.of("score1", "score2", "score3", "score4", "score5", "score6", "score7", "score8", "score9");
    private final List<String> scoreNo2 = List.of("score10", "score11", "score12", "score13", "score14", "score15", "score16", "score17", "score18");
    private final List<String> patNo1 = List.of("pat1", "pat2", "pat3", "pat4", "pat5", "pat6", "pat7", "pat8", "pat9");
    private final List<String> patNo2 = List.of("pat10", "pat11", "pat12", "pat13", "pat14", "pat15", "pat16", "pat17", "pat18");
    private boolean flag;

    private ScoreController() {
        for (var i = 1900; i <= 2100; i++) {
            this.years.add(i);
        }
        for (var i = 1; i <= 12; i++) {
            this.months.add(i);
        }
        for (var i = 1; i <= 31; i++) {
            this.days.add(i);
        }

        this.round1 = new ArrayList<>();
        this.round2 = new ArrayList<>();

        this.flag = true;
    }

    @GetMapping("Golf_Manager/user/insert")
    public String roundInsert(@ModelAttribute("RoundFrom") RoundForm RoundFrom, Model model) {
        model.addAttribute("courses", courseService.findAll());
        //年月日セレクトボックス要素
        model.addAttribute("years", this.years);
        model.addAttribute("months", this.months);
        model.addAttribute("days", this.days);
        //コース情報表示
        model.addAttribute("course", courseService.findById(1));
        model.addAttribute("holeNo1", this.holeNo1);
        model.addAttribute("holeNo2", this.holeNo2);
        //日付セット
        LocalDateTime nowDate = LocalDateTime.now();
        DateTimeFormatter year = DateTimeFormatter.ofPattern("yyyy");
        DateTimeFormatter month = DateTimeFormatter.ofPattern("M");
        DateTimeFormatter day = DateTimeFormatter.ofPattern("d");
        String formatNowDateYear = year.format(nowDate);
        String formatNowDateMonth = month.format(nowDate);
        String formatNowDateDay = day.format(nowDate);
        RoundFrom.setPlayDateYear(formatNowDateYear);
        RoundFrom.setPlayDateMonth(formatNowDateMonth);
        RoundFrom.setPlayDateDay(formatNowDateDay);

        //仮データ
        RoundFrom.setScoreHole1("4");
        RoundFrom.setScoreHole2("4");
        RoundFrom.setScoreHole3("4");
        RoundFrom.setScoreHole4("4");
        RoundFrom.setScoreHole5("4");
        RoundFrom.setScoreHole6("4");
        RoundFrom.setScoreHole7("4");
        RoundFrom.setScoreHole8("4");
        RoundFrom.setScoreHole9("4");
        RoundFrom.setScoreHole10("4");
        RoundFrom.setScoreHole11("4");
        RoundFrom.setScoreHole12("4");
        RoundFrom.setScoreHole13("4");
        RoundFrom.setScoreHole14("4");
        RoundFrom.setScoreHole15("4");
        RoundFrom.setScoreHole16("4");
        RoundFrom.setScoreHole17("4");
        RoundFrom.setScoreHole18("4");
        RoundFrom.setPatHole1("2");
        RoundFrom.setPatHole2("2");
        RoundFrom.setPatHole3("2");
        RoundFrom.setPatHole4("2");
        RoundFrom.setPatHole5("2");
        RoundFrom.setPatHole6("2");
        RoundFrom.setPatHole7("2");
        RoundFrom.setPatHole8("2");
        RoundFrom.setPatHole9("2");
        RoundFrom.setPatHole10("2");
        RoundFrom.setPatHole11("2");
        RoundFrom.setPatHole12("2");
        RoundFrom.setPatHole13("2");
        RoundFrom.setPatHole14("2");
        RoundFrom.setPatHole15("2");
        RoundFrom.setPatHole16("2");
        RoundFrom.setPatHole17("2");
        RoundFrom.setPatHole18("2");
        return "roundInsert";
    }

    @PostMapping("Golf_Manager/user/insert")
    public String roundInsert(@Validated @ModelAttribute("RoundFrom") RoundForm RoundFrom, BindingResult bindingResult, Model model) {
        //バリデーション
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "全てのスコアを入力してください");
            //コースセレクトボックス要素
            model.addAttribute("courses", courseService.findAll());
            //年月日セレクトボックス要素
            model.addAttribute("years", this.years);
            model.addAttribute("months", this.months);
            model.addAttribute("days", this.days);
            //コース情報表示
            model.addAttribute("course", courseService.findById(Integer.parseInt(RoundFrom.getCourseId())));
            model.addAttribute("holeNo1", this.holeNo1);
            model.addAttribute("holeNo2", this.holeNo2);
            //日時表示
            RoundFrom.setPlayDateYear(RoundFrom.getPlayDateYear());
            RoundFrom.setPlayDateMonth(RoundFrom.getPlayDateMonth());
            RoundFrom.setPlayDateDay(RoundFrom.getPlayDateDay());
            RoundFrom.setCourseId(RoundFrom.getCourseId());
            return "roundInsert";
        } else {
            List<String> scores = List.of(RoundFrom.getScoreHole1(), RoundFrom.getScoreHole2(), RoundFrom.getScoreHole3(), RoundFrom.getScoreHole4(), RoundFrom.getScoreHole5(), RoundFrom.getScoreHole6(), RoundFrom.getScoreHole7(), RoundFrom.getScoreHole8(), RoundFrom.getScoreHole9(), RoundFrom.getScoreHole10(), RoundFrom.getScoreHole11(), RoundFrom.getScoreHole12(), RoundFrom.getScoreHole13(), RoundFrom.getScoreHole14(), RoundFrom.getScoreHole15(), RoundFrom.getScoreHole16(), RoundFrom.getScoreHole17(), RoundFrom.getScoreHole18());
            List<String> pats = List.of(RoundFrom.getPatHole1(), RoundFrom.getPatHole2(), RoundFrom.getPatHole3(), RoundFrom.getPatHole4(), RoundFrom.getPatHole5(), RoundFrom.getPatHole6(), RoundFrom.getPatHole7(), RoundFrom.getPatHole8(), RoundFrom.getPatHole9(), RoundFrom.getPatHole10(), RoundFrom.getPatHole11(), RoundFrom.getPatHole12(), RoundFrom.getPatHole13(), RoundFrom.getPatHole14(), RoundFrom.getPatHole15(), RoundFrom.getPatHole16(), RoundFrom.getPatHole17(), RoundFrom.getPatHole18());
            this.round1.clear();
            this.round2.clear();
            for (var i = 1; i <= 18; i++) {
                if (i < 10) {
                    this.round1.add(new Hole(0, i, Integer.parseInt(scores.get(i - 1)), Integer.parseInt(pats.get(i - 1)), 0, 0, 0, 0));

                } else {
                    this.round2.add(new Hole(0, i, Integer.parseInt(scores.get(i - 1)), Integer.parseInt(pats.get(i - 1)), 0, 0, 0, 0));

                }
            }
            List<Hole> round = Stream.concat(round1.stream(), round2.stream()).collect(Collectors.toList());
            var id = findUserId(session.getAttribute("user"));
            var insertY = RoundFrom.getPlayDateYear();
            var insertM = RoundFrom.getPlayDateMonth();
            var insertD = RoundFrom.getPlayDateDay();
            insertM = String.format("%02d", Integer.parseInt(insertM));
            insertD = String.format("%02d", Integer.parseInt(insertD));
            try {
                roundService.insert(new Score(0, id, insertY+"-"+insertM+"-"+insertD, Integer.parseInt(RoundFrom.getCourseId()), RoundFrom.getNote()), round);
            } catch (NoSuchPostalCodeException e) {
                model.addAttribute("error", "更新時にエラーが発生しました");
                model.addAttribute("error", "全てのスコアを入力してください");
                //コースセレクトボックス要素
                model.addAttribute("courses", courseService.findAll());
                //年月日セレクトボックス要素
                model.addAttribute("years", this.years);
                model.addAttribute("months", this.months);
                model.addAttribute("days", this.days);
                //コース情報表示
                model.addAttribute("course", courseService.findById(Integer.parseInt(RoundFrom.getCourseId())));
                model.addAttribute("holeNo1", this.holeNo1);
                model.addAttribute("holeNo2", this.holeNo2);
                return "roundInsert";
            }
            return "redirect:/Golf_Manager/user/menu";
        }
    }

    @GetMapping("Golf_Manager/user/round-all")
    public String UserDetail(Model model) {
        var rounds = roundService.findAll(findUserId(session.getAttribute("user")));
        model.addAttribute("rounds", rounds);
        model.addAttribute("courses", courseService.findAll());
        return "roundAll";
    }

    @GetMapping("Golf_Manager/user/round-all/Search")
    public String UserDetailSearch(@RequestParam(name="search") String search, @RequestParam(name="order") int sort, Model model) {
        var rounds = roundService.findAll(findUserId(session.getAttribute("user")));
        model.addAttribute("rounds", rounds);
        model.addAttribute("courses", courseService.findAll());
        return "roundAll";
    }

    @GetMapping("Golf_Manager/user/detail/{id}")
    public String UserDetail(@PathVariable("id") int id, Model model) {
        model.addAttribute("holeIn", roundService.findHole1_9(id));
        model.addAttribute("holeOut", roundService.findHole10_18(id));
        model.addAttribute("score", roundService.findScore(id));
        model.addAttribute("holeNo1", this.holeNo1);
        model.addAttribute("holeNo2", this.holeNo2);
        var score = roundService.findScore(id);
        model.addAttribute("course", courseService.findById(score.courseId()));
        return "detail";
    }

    @GetMapping("Golf_Manager/user/detail/{id}/update")
    public String UserDetailUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("holeIn", roundService.findHole1_9(id));
        model.addAttribute("holeOut", roundService.findHole10_18(id));
        model.addAttribute("score", roundService.findScore(id));
        model.addAttribute("holeNo1", this.holeNo1);
        model.addAttribute("holeNo2", this.holeNo2);
        var score = roundService.findScore(id);
        model.addAttribute("course", courseService.findById(score.courseId()));
        return "roundUpdate";
    }

    @PostMapping("Golf_Manager/user/detail/{id}/delete")
    public String UserDetailDelete(@PathVariable("id") int id, Model model) {
        try {
            roundService.delete(id);
        } catch (NoSuchPostalCodeException e) {
            return "/Golf_Manager/user/detail/{id}";
        }
        return "redirect:/Golf_Manager/user/menu";
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