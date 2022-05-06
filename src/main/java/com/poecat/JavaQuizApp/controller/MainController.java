package com.poecat.JavaQuizApp.controller;

import com.poecat.JavaQuizApp.model.Result;
import com.poecat.JavaQuizApp.service.QuestionForm;
import com.poecat.JavaQuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    Result result;
    @Autowired
    QuizService qService;

    public boolean submitted = false;


    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @ModelAttribute("result")
    public Result getResult() {
        return result;
    }

    @PostMapping("/quiz")
    public String quiz(@RequestParam String username, Model m, RedirectAttributes ra) {
        if(username.equals("")) {
            ra.addFlashAttribute("warning", "You must enter your name first!");
            return "redirect:/";
        }

        submitted = false;
        result.setUsername(username);

        QuestionForm qForm = qService.getQuestions();
        m.addAttribute("qForm", qForm);

        return "quiz.html";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute QuestionForm qForm, Model m) {
        if(!submitted) {
            result.setTotalCorrect(qService.getResult(qForm));
            result.setPercent((qService.getResult(qForm)) * 100.0 / qService.questionsOnPage);
            m.addAttribute("percent", result.getPercent());

            if(result.getPercent() >= 80.0) {
                m.addAttribute("message", "Congratulations, you're good!");
            } else if (result.getPercent() >= 50.0){
                m.addAttribute("message", "Not bad!");
            }

            qService.saveScore(result);
            submitted = true;
        }

        return "result.html";
    }

    @GetMapping("/score")
    public String score(Model m) {
        List<Result> sList = qService.getTopScore();
        m.addAttribute("sList", sList);

        return "scoreboard.html";
    }
}
