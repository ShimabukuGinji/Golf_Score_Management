package com.example.golfscoremanagement.controller;

import com.example.golfscoremanagement.entity.Hole;
import com.example.golfscoremanagement.entity.Score;
import com.example.golfscoremanagement.exception.NoSuchPostalCodeException;
import com.example.golfscoremanagement.form.RoundForm;
import com.example.golfscoremanagement.form.RoundForm1;
import com.example.golfscoremanagement.form.RoundForm2;
import com.example.golfscoremanagement.service.ICourseService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        RoundFrom.setScoreHole1("");
        RoundFrom.setScoreHole2("");
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
            var users = userService.findAll();
            var id = -1;
            for (var i = 0; i < users.size(); i++) {
                if (users.get(i).equals(session.getAttribute("user"))) {
                    id = users.get(i).id();
                }
            }
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
            return "redirect:/Golf_Manager/user/insert";
        }
    }
}

//    @GetMapping("Golf_Manager/user/insert/{courseId}")
//    public String roundInsert(@ModelAttribute("RoundFrom2") RoundForm2 RoundFrom2, @PathVariable("courseId") int courseId, Model model) {
//        if (flag) {
//            model.addAttribute("course", courseService.findById(courseId));
//            model.addAttribute("holeNo1", this.holeNo1);
//            model.addAttribute("holeNo2", this.holeNo2);
//            return "roundInsert2";
//        } else {
//            flag = true;
//            model.addAttribute("course", courseService.findById(courseId));
//            model.addAttribute("holeNo1", this.holeNo1);
//            model.addAttribute("holeNo2", this.holeNo2);
//            model.addAttribute("error", "全てのスコアを入力してください");
//            return "roundInsert2";
//        }
//    }
//
//    @PostMapping("Golf_Manager/user/insert/{courseId}/check")
//    public String roundInsert(@Validated @ModelAttribute("RoundFrom2") RoundForm2 RoundFrom2, BindingResult bindingResult, @PathVariable("courseId") int courseId, Model model) throws NoSuchPostalCodeException {
//        //バリデーション
//        if(bindingResult.hasErrors()) {
//            this.flag = false;
//            return "redirect:/Golf_Manager/user/insert/{courseId}";
//        }
//        List<String> scores = List.of(RoundFrom2.getScoreHole1(),RoundFrom2.getScoreHole2(),RoundFrom2.getScoreHole3(),RoundFrom2.getScoreHole4(),RoundFrom2.getScoreHole5(),RoundFrom2.getScoreHole6(),RoundFrom2.getScoreHole7(),RoundFrom2.getScoreHole8(),RoundFrom2.getScoreHole9(),RoundFrom2.getScoreHole10(),RoundFrom2.getScoreHole11(),RoundFrom2.getScoreHole12(),RoundFrom2.getScoreHole13(),RoundFrom2.getScoreHole14(),RoundFrom2.getScoreHole15(),RoundFrom2.getScoreHole16(),RoundFrom2.getScoreHole17(),RoundFrom2.getScoreHole18());
//        List<String> pats = List.of(RoundFrom2.getPatHole1(),RoundFrom2.getPatHole2(),RoundFrom2.getPatHole3(),RoundFrom2.getPatHole4(),RoundFrom2.getPatHole5(),RoundFrom2.getPatHole6(),RoundFrom2.getPatHole7(),RoundFrom2.getPatHole8(),RoundFrom2.getPatHole9(),RoundFrom2.getPatHole10(),RoundFrom2.getPatHole11(),RoundFrom2.getPatHole12(),RoundFrom2.getPatHole13(),RoundFrom2.getPatHole14(),RoundFrom2.getPatHole15(),RoundFrom2.getPatHole16(),RoundFrom2.getPatHole17(),RoundFrom2.getPatHole18());
//        this.round1.clear();
//        this.round2.clear();
//        for (var i=1; i<=18; i++) {
//            if (i < 10) {
//                this.round1.add(new Hole(0, i, Integer.parseInt(scores.get(i-1)), Integer.parseInt(pats.get(i-1)), 0, 0, 0, 0));
//
//            } else {
//                this.round2.add(new Hole(0, i, Integer.parseInt(scores.get(i-1)), Integer.parseInt(pats.get(i-1)), 0, 0, 0, 0));
//
//            }
//        }
//        var users = userService.findAll();
//        var id = -1;
//        for (var i=0; i<users.size(); i++) {
//            if (users.get(i).equals(session.getAttribute("user"))){
//                id = users.get(i).id();
//            }
//        }
//        List<Hole> round = Stream.concat(round1.stream(), round2.stream()).collect(Collectors.toList());
//        roundService.insert(new Score(0, id, year+"-"+month+"-"+day, courseId, RoundFrom2.getNote()),round);
//        return "redirect:/Golf_Manager/user/menu";
//    }
//}